package com.example.nunorder2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



    public class MainActivity extends AppCompatActivity implements FoodAdapter.OnItemClickListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            RecyclerView recyclerView = findViewById(R.id.item_food);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Button orderSummaryButton = findViewById(R.id.btnOrderSummary);

            List<FoodItem> foodList = new ArrayList<>();
            foodList.add(new FoodItem("Jollof Rice", "Delicious Smoky Jollof Rice", R.drawable.jollofrice, 2000));
            foodList.add(new FoodItem("Chinese Noodles", " Savoury Chinese Noodles", R.drawable.chinese1, 3000));
            foodList.add(new FoodItem("Orange Chicken", "Spicy and Tangy Orange Chicken", R.drawable.chinese2, 3000));
            foodList.add(new FoodItem("Thai Rice", "Delicious Thai Rice", R.drawable.thai, 3000));
            foodList.add(new FoodItem("Thai Chicken", "Spicy and tangy Thai Chicken", R.drawable.thai, 3000));
            foodList.add(new FoodItem("Suya", " Suya", R.drawable.suya, 3000));

            FoodAdapter adapter = new FoodAdapter(foodList, this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onAddToCartClick(FoodItem foodItem) {
            Cart.getInstance().addItem(foodItem);
            Toast.makeText(this, foodItem.getName() + " added to cart", Toast.LENGTH_SHORT).show();
        }



            public void onOrderSummaryClick(View v) {

                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                startActivity(intent);
            }

    }
