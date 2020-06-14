package com.example.widgetapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioButtonClass extends AppCompatActivity {
    // properties
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
    }

    public void RedioBtnClciked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btn1:
                if (checked)
                    string = "Lenovo";
                    Toast.makeText(RadioButtonClass.this,"Lenovo Choosed!",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn2:
                if (checked)
                    string = "Asus";
                    Toast.makeText(RadioButtonClass.this,"Asus Choosed!",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn3:
                if (checked)
                    string = "HP";
                Toast.makeText(RadioButtonClass.this,"HP Choosed!",Toast.LENGTH_LONG).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    // btn submit for edit text
    public void submit(View view) {
        // intent one activaty to another activaty going
        Intent intent = new Intent(this, RadioInputDisplayActivaty.class);

        EditText editText = findViewById(R.id.edtxt);

        intent.putExtra("radioChoosenValue", string); //radioChoosen is key for receving activaty
        intent.putExtra("edTextValue", editText.getText().toString());
        startActivity(intent);

    }
}