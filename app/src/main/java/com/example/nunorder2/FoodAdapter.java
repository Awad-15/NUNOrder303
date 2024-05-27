package com.example.nunorder2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<FoodItem> foodList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onAddToCartClick(FoodItem foodItem);
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public ImageView foodImageView;
        public TextView foodNameTextView;
        public TextView foodDescriptionTextView;
        public TextView foodPriceTextView;
        public Button addToCartButton;

        public FoodViewHolder(View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
            foodDescriptionTextView = itemView.findViewById(R.id.foodDescriptionTextView);
            foodPriceTextView = itemView.findViewById(R.id.foodPriceTextView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }

    public FoodAdapter(List<FoodItem> foodList, OnItemClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        FoodItem foodItem = foodList.get(position);
        holder.foodImageView.setImageResource(foodItem.getImageResourceId());
        holder.foodNameTextView.setText(foodItem.getName());
        holder.foodDescriptionTextView.setText(foodItem.getDescription());
        holder.foodPriceTextView.setText("Price: ₦" + foodItem.getPrice());
        holder.addToCartButton.setOnClickListener(v -> listener.onAddToCartClick(foodItem));

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}