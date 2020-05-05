package com.example.edittext_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // property

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get button click event by setOnClickListener
        // button click go next activity
        // button click go anothe activity
        Button onclickListenerButton = findViewById(R.id.submit2);
        onclickListenerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                // short
                //startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    }

    // onclick event
    // ctrl + shift + backslash for multi line comment
    public void submit(View view) {
        // Toast.makeText(this, "Button Clicked Successfull", Toast.LENGTH_SHORT).show();
        EditText name = findViewById(R.id.name);
        EditText address = findViewById(R.id.address);

        TextView result = findViewById(R.id.result);

        String inputName = name.getText().toString();
        String inputAddress = address.getText().toString();

        result.setText("Name: " + inputName + " \n Address: " + inputAddress);
        Toast.makeText(this, inputName, Toast.LENGTH_LONG).show();

     }
}
