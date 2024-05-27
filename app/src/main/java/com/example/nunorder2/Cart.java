package com.example.nunorder2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<FoodItem> cartItems;

    private Cart() {
        cartItems = new ArrayList<>();
    }

    public static synchronized Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(FoodItem item) {
        cartItems.add(item);
    }

    public List<FoodItem> getItems() {
        return new ArrayList<>(cartItems);
    }

    public void clear() {
        cartItems.clear();
    }
}
