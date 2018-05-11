package com.example.itadmin.todolist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itadmin.todolist.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    private Activity activity;
    private ArrayList<Product> products;
    private static LayoutInflater inflater = null;

    public ProductAdapter (Activity activity, int textViewResourceId,ArrayList<Product> products) {
        super(activity, textViewResourceId, products);
        try {
            this.activity = activity;
            this.products = products;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return products.size();
    }

    public Product getItem(Product position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView nameText;
        public TextView descText;
        public TextView priceText;
        public ImageView productImageView;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.productitem, null);
                holder = new ViewHolder();

                holder.nameText = (TextView) vi.findViewById(R.id.nameText);
                holder.descText = (TextView) vi.findViewById(R.id.descText);
                holder.priceText = (TextView) vi.findViewById(R.id.priceText);
                holder.productImageView = (ImageView) vi.findViewById(R.id.productImageView);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.nameText.setText(products.get(position).getName());
            holder.descText.setText(products.get(position).getDescription());
            holder.priceText.setText(products.get(position).getPrice());
            holder.productImageView.setImageDrawable(products.get(position).getProductImage());


        } catch (Exception e) {


        }
        return vi;
    }
}