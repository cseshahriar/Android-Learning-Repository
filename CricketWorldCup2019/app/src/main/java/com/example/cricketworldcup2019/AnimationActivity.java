package com.example.cricketworldcup2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    Button animationBtn;
    ImageView catImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        animationBtn = findViewById(R.id.animationBtn);
        catImage = findViewById(R.id.catImage);

        animationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fade in, fade out
                //catImage.animate().alpha(0f).setDuration(5000); // milisecond
                // catImage.animate().alpha(1f).setDuration(5000); // milisecond

                catImage.animate().translationX(100f).setDuration(5000);
            }
        });
    }
}
