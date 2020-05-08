package com.example.playwithnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button submitBtn;
    EditText input;
    int randomNumber, userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        submitBtn = findViewById(R.id.submitBtn);
        display = findViewById(R.id.display);

        // random number
        Random rand = new Random();
        randomNumber = rand.nextInt(10);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNumberStr = input.getText().toString();
                userNumber = Integer.parseInt(userNumberStr);

                // logic
                if(userNumber < randomNumber) {
                    Toast.makeText(MainActivity.this, "Please enter higher number", Toast.LENGTH_SHORT).show();
                } else if(userNumber > randomNumber) {
                    Toast.makeText(MainActivity.this, "Please enter lower number", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Congratulation! You enter right number", Toast.LENGTH_SHORT).show();
                    // re-generate random number
                    Random rand = new Random();
                    randomNumber = rand.nextInt(10);
                    input.setText(" ");
                }
            }
        });
    }
}
