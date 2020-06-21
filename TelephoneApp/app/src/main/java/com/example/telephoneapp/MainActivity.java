package com.example.telephoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // properties
    EditText editText;
    Button button;
    private  int PHONE_PERMISSION_CODE = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.phone);
        button = findViewById(R.id.callbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number =  editText.getText().toString();
                if (number == "null" || number == "") {
                    Toast.makeText(MainActivity.this, "Phone number is required!", Toast.LENGTH_SHORT).show();
                } else {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            MainActivity.this.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number)));
                        } else {
                            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,  Manifest.permission.CALL_PHONE)) {
                                Toast.makeText(MainActivity.this, "App requires Phone Call  Permission!", Toast.LENGTH_SHORT).show();
                            }
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PHONE_PERMISSION_CODE);
                        }
                    } else {
                        MainActivity.this.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number)));
                    }
                }
            }
        });
    }
}