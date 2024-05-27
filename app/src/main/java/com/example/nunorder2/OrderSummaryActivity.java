package com.example.nunorder2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        RecyclerView orderRecyclerView = findViewById(R.id.orderRecyclerView);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<FoodItem> cartItems = Cart.getInstance().getItems();
        FoodAdapter adapter = new FoodAdapter(cartItems, foodItem -> {});
        orderRecyclerView.setAdapter(adapter);
    }

    public void placeOrder(View view) {
        Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show();
        Cart.getInstance().clear();
        finish();
        Intent intent = new Intent(OrderSummaryActivity.this, OrderProgressActivity.class);
        startActivity(intent);
    }
}
