package com.example.audiovideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button play, stop;
    MediaPlayer audioPlayer;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playBtn);
        stop = findViewById(R.id.stopBtn);

        // audio path
        audioPlayer = MediaPlayer.create(this, R.raw.great_goldfinch);

        // video
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.chelemanushi);
        MediaController controller  = new MediaController(this);
        controller.setAnchorView(controller);
        videoView.setMediaController(controller);
        videoView.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer.stop();
            }
        });
    }

}
