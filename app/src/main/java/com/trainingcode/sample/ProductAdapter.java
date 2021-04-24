package com.trainingcode.sample;

import android.content.Context;
import android.content.Intent;
import android.gesture.GestureLibraries;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private  Context mContext;
    List<ProductModel> productModelList;
    View view;

    public ProductAdapter(Context mContext, List<ProductModel> productModelList) {
        this.mContext = mContext;
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);

        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.iv_Image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.p1));
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png")
//                .resize(50, 50)
//                .centerCrop()
//
//                .into(holder.iv_Image);
//        Picasso.with(mContext)
//                .load("https://avatars.githubusercontent.com/u/1?v=4")
//
//                .into(holder.iv_Image );
      Glide.with(mContext).load(productModelList.get(position).getOwner().getAvatarUrl()).placeholder(R.drawable.ic_launcher_background).into(holder.iv_Image);
        holder.tvTitle.setText(productModelList.get(position).getName());
        holder.tvDesc.setText(productModelList.get(position).getDescription());
        holder.iv_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
ProductModel productModel=productModelList.get(position);
                Intent intent=new Intent(mContext,ShowDetails.class);
                ShowDetails.subcourcemodel=productModel;
                if(holder.edComments.getText().length() != 0) {
                    intent.putExtra("Comments", holder.edComments.getText().toString());
                }
                else{
                    intent.putExtra("Comments", "No comments Added");
                }
              mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder{
        ImageView iv_Image;
        TextView tvTitle,tvDesc;
        EditText edComments;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            iv_Image=  itemView.findViewById(R.id.imageView);
            tvTitle=  itemView.findViewById(R.id.tvTitle);
            tvDesc=  itemView.findViewById(R.id.tvDesc);
            edComments=  itemView.findViewById(R.id.edComments);
        }
    }
}
