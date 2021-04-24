package com.trainingcode.sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvProductList;
    List<ProductModel> productModelList = new ArrayList<>();
    ProductModel productModel;
    ProductAdapter productAdapter;
    APIInterface APIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0D58A1"));


        actionBar.setBackgroundDrawable(colorDrawable);
        rvProductList = findViewById(R.id.rvProductList);

        loadlist();
    }


    public void loadlist(){
        APIInterface=APIClient.getApiClient().create(APIInterface.class);
        Call<List<ProductModel>> call=APIInterface.getAllDatas();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                if (response.isSuccessful()) {
                    Log.e("Success", new Gson().toJson(response.body()));

                    productModelList = response.body();

                    productAdapter = new ProductAdapter(MainActivity.this,productModelList);
                    LinearLayoutManager llmanager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                    rvProductList.setLayoutManager(llmanager);

                    rvProductList.setAdapter(productAdapter);

                }
                else
                    Log.e("unSuccess", new Gson().toJson(response.errorBody()));


            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

            }
        });


    }

}