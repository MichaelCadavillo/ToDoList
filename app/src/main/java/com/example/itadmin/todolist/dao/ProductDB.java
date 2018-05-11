package com.example.itadmin.todolist.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_PRODUCTS = "products_table";
    public static final String TABLE_PRODUCTS_ID = "id";
    public static final String TABLE_PRODUCTS_NAME = "name";
    public static final String TABLE_PRODUCTS_DESC = "desc";
    public static final String TABLE_PRODUCTS_PRICE = "price";
    public static final String TABLE_PRODUCTS_IMAGE = "image";
    //public static final String TABLE_PRODUCTS_QUANTITY = "quantity";

    private static final String CREATE_PRODUCTS_TABLE = "create table " + TABLE_PRODUCTS + "(" + TABLE_PRODUCTS_ID + " integer primary key autoincrement, " +
            TABLE_PRODUCTS_NAME + " text, " +
            TABLE_PRODUCTS_DESC + " text, " +
            TABLE_PRODUCTS_PRICE + " text, " +
            /*TABLE_PRODUCTS_QUANTITY + " text, " +*/
            TABLE_PRODUCTS_IMAGE + " text" +
            ");";

    public ProductDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }
}
