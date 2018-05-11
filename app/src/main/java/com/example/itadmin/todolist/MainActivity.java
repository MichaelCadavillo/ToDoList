package com.example.itadmin.todolist;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.itadmin.todolist.dao.ProductDAO;
import com.example.itadmin.todolist.dao.ProductDAOSQLImpl;
import com.example.itadmin.todolist.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ListView listView;
    private ArrayList<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        /*ProductDAO db = new ProductDAOSQLImpl(getApplicationContext());
        ProductAdapter adapter = new ProductAdapter(MainActivity.this, 0, db.getProducts());
        listView.setAdapter(adapter);

        for(Product product: db.getProducts()){
            products.add(product);
        }*/

    }

    public void addItem(View view){
        Intent intent = new Intent(MainActivity.this, addItemActivity.class);
        startActivity(intent);
    }


}
