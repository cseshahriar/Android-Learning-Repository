package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // property
    EditText inputAmount;
    TextView resultTV;
    String amount, displayAmount;
    Double dblAmount, resultAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        this.inputAmount = findViewById(R.id.amount);
        this.resultTV = findViewById(R.id.result);
    }

    public void convert(View view) {

        // calculation
        this.amount = inputAmount.getText().toString();
        this.dblAmount =  Double.parseDouble(amount);

        this.resultAmount = dblAmount * 0.012;
        this.displayAmount = resultAmount.toString();

        resultTV.setText("$ "+displayAmount);

    }
}
