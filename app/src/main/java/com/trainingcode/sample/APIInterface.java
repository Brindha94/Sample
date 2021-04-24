package com.trainingcode.sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("/repositories")
   Call<List<ProductModel>> getAllDatas();

}
