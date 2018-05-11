package com.example.itadmin.todolist.dao;

import com.example.itadmin.todolist.model.Product;

import java.util.ArrayList;

public interface ProductDAO {
    public void addProduct(Product product);
    public ArrayList<Product> getProducts();
}
