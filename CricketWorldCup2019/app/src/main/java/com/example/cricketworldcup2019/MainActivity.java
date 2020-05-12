package com.example.cricketworldcup2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button covid19, liveScore, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        covid19 = findViewById(R.id.btn1);
        liveScore = findViewById(R.id.btn6);

        covid19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this, WebViewActivity.class);
                go.putExtra("URL1", "https://www.worldometers.info/coronavirus/");
                startActivity(go);
            }
        });

        liveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this, WebViewActivity.class);
                go.putExtra("URL2", "https://www.prothomalo.com/");
                startActivity(go);
            }
        });
    }
}
