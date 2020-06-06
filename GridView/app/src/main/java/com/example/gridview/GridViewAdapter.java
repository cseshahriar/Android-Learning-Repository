package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    ArrayList<Cricketer> cricketers = new ArrayList<>();
    Context context;

    public GridViewAdapter(ArrayList<Cricketer> cricketers, Context context) {
        this.cricketers = cricketers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cricketers.size();
    }

    @Override
    public Object getItem(int position) {
        return  null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_layout, null);

        ImageView imageView = customView.findViewById(R.id.imageView);
        TextView textView = customView.findViewById(R.id.textView);


        imageView.setImageResource(cricketers.get(position).getImage());
        textView.setText(cricketers.get(position).getName());

        return  customView;
    }
}
