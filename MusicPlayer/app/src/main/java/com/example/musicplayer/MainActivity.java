package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button playBtn, stopBtn;
    MediaPlayer audioPlayer;
    SeekBar volumeController, locationControler;
    AudioManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioPlayer = MediaPlayer.create(this, R.raw.goldfinch);
        volumeController = findViewById(R.id.volumeSeekBar);
        locationControler = findViewById(R.id.timeSeekBar);

        // manager
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolune = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currVolume = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        volumeController.setMax(maxVolune);
        volumeController.setProgress(currVolume);

        // seekbar
        volumeController.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // music progress
        locationControler.setMax(audioPlayer.getDuration());
        // timer
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                locationControler.setProgress(audioPlayer.getCurrentPosition());
            }
        }, 0, 100);

        locationControler.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    // outside of oncreate
    public  void  playMusic(View view) {

        audioPlayer.start();
    }

    public void stopMusic(View view) {
        audioPlayer.stop();
    }
}
