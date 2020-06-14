package com.example.widgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RadioInputDisplayActivaty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_input_display_activaty);

        TextView textViewForET = findViewById(R.id.tv1);
        TextView textViewForRadio = findViewById(R.id.tv2);

        // received values
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String msg = extras.getString("radioChoosenValue");
            textViewForRadio.setText(msg);

            Intent intent = getIntent();
            String str = intent.getStringExtra("edTextValue");
            textViewForET.setText(str);
        }
    }
}