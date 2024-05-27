package com.example.nunorder2;

public class FoodItem {
    private String name;
    private String description;
    private int imageResourceId;
    private double price;

    public FoodItem(String name, String description, int imageResourceId, double price) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageResourceId() { return imageResourceId; }
    public double getPrice() { return price; }
}