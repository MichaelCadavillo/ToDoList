package com.example.itadmin.todolist.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Product {

    private String name;
    private String description;
    private String price;
    private Drawable productImage;

    public Product(){}

    public Product(String name, String description, String price, Drawable productImage){
        this.name = name;
        this.description = description;
        this.price = price;
        this.productImage = productImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Drawable getProductImage() {
        return productImage;
    }

    public void setProductImage(Drawable productImage) {
        this.productImage = productImage;
    }
}
