package com.example.listviewandgridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

// Custom list adapter
public class CustomListadaptar extends ArrayAdapter {

    private  final Activity context;
    private final String[] fruits;
    private final Integer[] image;

    public CustomListadaptar(@NonNull Context context, ListView firstListView, String[] fruits, Integer[] image) {

        super(context, R.layout.mycustomlist,fruits);

        this.context = (Activity) context;
        this.fruits = fruits;
        this.image = image;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mycustomlist, null, true);

        TextView fruidTv = rowView.findViewById(R.id.textId);
        ImageView imgView = rowView.findViewById(R.id.leftImg);

        fruidTv.setText(fruits[position]);
        imgView.setImageResource(image[position]);

        return rowView;
    }
}
