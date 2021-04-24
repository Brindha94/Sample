package com.trainingcode.sample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ShowDetails extends AppCompatActivity {
    TextView tv_title,tv_desc,tvComment;
    ImageView iv_image;
    public static ProductModel subcourcemodel = new ProductModel();
    String comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0D58A1"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
            comment= getIntent().getExtras().getString("Comments");

        iv_image = findViewById(R.id.iv_image);
        tv_title = findViewById(R.id.tv_title);
        tv_desc = findViewById(R.id.tv_desc);
        tvComment = findViewById(R.id.tvComment);
        Glide.with(this).
                load(subcourcemodel.getOwner().getAvatarUrl()).placeholder(R.drawable.ic_launcher_background).into(iv_image);
        tv_title.setText(subcourcemodel.getName());
        tv_desc.setText(subcourcemodel.getDescription());

            tvComment.setText(comment);


    }
}