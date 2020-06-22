package com.example.telephoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // properties
    EditText editText, msg, emailEt;
    Button button, smsbutton, emailbutton;
    private  int PHONE_PERMISSION_CODE = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.phone);
        msg = findViewById(R.id.msgEt);
        emailEt = findViewById(R.id.emailEt);
        button = findViewById(R.id.callbtn);
        smsbutton = findViewById(R.id.smsbtn);
        emailbutton = findViewById(R.id.emailbtn);


        final String mobileNumber = editText.getText().toString();

        // makeing a phone call
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mobileNumber == "null" || mobileNumber == "") {
                    Toast.makeText(MainActivity.this, "Phone number is required!", Toast.LENGTH_SHORT).show();
                } else {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                            MainActivity.this.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobileNumber)));
                        } else {
                            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,  Manifest.permission.CALL_PHONE)) {
                                Toast.makeText(MainActivity.this, "App requires Phone Call  Permission!", Toast.LENGTH_SHORT).show();
                            }
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PHONE_PERMISSION_CODE);
                        }
                    } else {
                        MainActivity.this.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mobileNumber)));
                    }
                }
            }
        });

        // sms sending
        smsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String sms    = msg.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + mobileNumber));
                intent.putExtra("sms_body", sms);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Message has been successfully send!", Toast.LENGTH_SHORT).show();
            }
        });

        // email sending
        emailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}