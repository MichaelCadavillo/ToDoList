package com.example.itadmin.todolist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.itadmin.todolist.model.Product;

import java.util.ArrayList;

public class ProductDAOSQLImpl implements ProductDAO {
    private SQLiteDatabase db;
    private ProductDB helper;

    public ProductDAOSQLImpl(Context context){
        helper = new ProductDB(context);
    }

    public void open() throws SQLException{
        this.db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    @Override
    public void addProduct(Product product) {
        try{
            open();

            ContentValues values = new ContentValues();
            values.put(ProductDB.TABLE_PRODUCTS_NAME, product.getName());
            values.put(ProductDB.TABLE_PRODUCTS_DESC, product.getDescription());
            values.put(ProductDB.TABLE_PRODUCTS_PRICE, product.getPrice());
            values.put(ProductDB.TABLE_PRODUCTS_IMAGE, product.getProductImage().toString());

            db.insert(ProductDB.TABLE_PRODUCTS, null , values);

            close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        Cursor cursor;

        try{
            open();

            cursor = db.query(ProductDB.TABLE_PRODUCTS, new String[]{ProductDB.TABLE_PRODUCTS_ID, ProductDB.TABLE_PRODUCTS_NAME, ProductDB.TABLE_PRODUCTS_DESC, ProductDB.TABLE_PRODUCTS_PRICE, ProductDB.TABLE_PRODUCTS_IMAGE}, null, null, null, null, null, null);

            cursor.moveToFirst();

            if(!cursor.isAfterLast()){
                do{
                    Product temp = new Product();

                    temp.setName(cursor.getString(cursor.getColumnIndex(ProductDB.TABLE_PRODUCTS_NAME)));
                    temp.setDescription(cursor.getString(cursor.getColumnIndex(ProductDB.TABLE_PRODUCTS_DESC)));
                    temp.setPrice(cursor.getString(cursor.getColumnIndex(ProductDB.TABLE_PRODUCTS_PRICE)));
                    //temp.setProductImage(cursor.getString(cursor.getColumnIndex(ProductDB.TABLE_PRODUCTS_IMAGE)));

                    products.add(temp);

                }while (cursor.moveToNext());
            }

            cursor.close();
            close();
        }catch (Exception e){

        }
        return products;
    }
}
