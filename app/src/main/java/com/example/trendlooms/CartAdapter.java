package com.example.trendlooms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder>{
    public CartAdapter(Context context) {
        this.context = context;
        productModelList=new ArrayList<>();
    }
   public void addProduct(CartModel productModel){
        productModelList.add(productModel);
        notifyDataSetChanged();
   }
    private Context context;
    private List<CartModel> productModelList;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row ,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CartModel productModel=productModelList.get(position);
        holder.title.setText(productModel.getProductName());
        holder.qty.setText(productModel.getQty());

        holder.price.setText(productModel.getProductPrice());

        Glide.with(context).load(productModel.getProductImage())
                .into(holder.img);



    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title,desc,price,qty;
        private ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            qty=itemView.findViewById(R.id.qty);
            price=itemView.findViewById(R.id.price);
            img=itemView.findViewById(R.id.image);
        }
    }
}
