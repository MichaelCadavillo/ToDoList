package com.example.itadmin.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.itadmin.todolist.model.Product;

import java.util.ArrayList;

public class addItemActivity extends AppCompatActivity {

    private EditText name;
    private EditText desc;
    private EditText price;
    private ImageView productImage;
    private static ArrayList<Product> products = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);
        price = findViewById(R.id.price);
        productImage = findViewById(R.id.productImage);
    }

    public void addItemOnClick(View view){
        Product product = new Product(name.getText().toString(), desc.getText().toString(), price.getText().toString(), productImage.getDrawable());

        products.add(product);

        ProductAdapter productAdapter = new ProductAdapter(addItemActivity.this, 0, products);

        MainActivity.listView.setAdapter(productAdapter);

    }

}
