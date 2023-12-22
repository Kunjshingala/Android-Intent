package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AActivity extends AppCompatActivity {
    Button btn_one;
    EditText input_email;
    EditText input_country;
    EditText input_enrollment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);

        btn_one = (Button) findViewById(R.id.btn_one);

        input_email = (EditText) findViewById(R.id.input_email);
        input_country = (EditText) findViewById(R.id.input_country);
        input_enrollment = (EditText) findViewById(R.id.input_enrollment);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = input_email.getText().toString();
                String country = input_country.getText().toString();
                String enrollment = input_enrollment.getText().toString();

                Intent intent = new Intent(getApplicationContext(), BActivity.class);
                intent.putExtra("key_email", email);
                intent.putExtra("key_country", country);
                intent.putExtra("key_enrollment", enrollment);


                startActivity(intent);
            }
        });
    }
}