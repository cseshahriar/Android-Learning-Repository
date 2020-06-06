package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GridViewAdapter adapter;
    ArrayList<Cricketer> cricketers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        gridView = findViewById(R.id.gridView);
        cricketers = new ArrayList<>();
        setData();
        adapter = new GridViewAdapter(cricketers, MainActivity.this);
        gridView.setAdapter(adapter);

    }

    private void setData() {
        Cricketer mash = new Cricketer( R.drawable.mash,"Mashrafee");
        Cricketer tamim = new Cricketer(R.drawable.tamim, "Tamim");
        Cricketer riad = new Cricketer(R.drawable.riad, "Riad");
        Cricketer mushi = new Cricketer(R.drawable.musi, "Mushfiq");

        cricketers.add(mash);
        cricketers.add(tamim);
        cricketers.add(riad);
        cricketers.add(mushi);

        cricketers.add(mash);
        cricketers.add(tamim);
        cricketers.add(riad);
        cricketers.add(mushi);
    }
}
