package com.example.listviewandgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // properties
    ListView firstListView;
    // str and int array
    String[] fruits = {"Mango", "Banana", "Jackfruit", "Apple", "Litchi"};
    Integer[] image = {R.drawable.m, R.drawable.b, R.drawable.j, R.drawable.a, R.drawable.l};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get id
        firstListView = findViewById(R.id.firstList);

        // array adaptar
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);

        // custom list adapter
        CustomListadaptar customListadaptar = new CustomListadaptar(this, firstListView,fruits, image);
        firstListView.setAdapter(customListadaptar);
    }
}
