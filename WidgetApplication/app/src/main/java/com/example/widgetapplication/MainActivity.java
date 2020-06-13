package com.example.widgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // el
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        button = findViewById(R.id.bottom);
        tv = findViewById(R.id.tv);
    }

    public void order(View view) {
        int totalAmount = 0;

        StringBuilder result = new StringBuilder();
        result.append("Select Item: ");

        if (cb1.isChecked()) {
            result.append("\nPizza 100TK");
            totalAmount += 100;
        }

        if (cb2.isChecked()) {
            result.append("\nCoffe 50TK");
            totalAmount += 50;
        }

        if (cb3.isChecked()) {
            result.append("\nBurger 120TK");
            totalAmount += 120;
        }

        result.append("\nTotal: " + totalAmount + "TK");
        tv.setText(result);
    }
}