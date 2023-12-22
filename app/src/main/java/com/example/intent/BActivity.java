package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BActivity extends AppCompatActivity {

    Button btn_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        btn_two = (Button) findViewById(R.id.btn_two);

        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("key_email");
        String country = bundle.getString("key_country");
        String enrollment = bundle.getString("key_enrollment");

//        to display data in tost
//        Toast.makeText(this, email + " , " + country+" , "+enrollment,Toast.LENGTH_SHORT).show();

        TextView txtView_email = findViewById(R.id.display_email);
        txtView_email.setText("Email : " + email);

        TextView txtView_counrty = findViewById(R.id.display_country);
        txtView_counrty.setText("Coutry : " + country);

        TextView txtView_enrollment = findViewById(R.id.display_enrollment);
        txtView_enrollment.setText("Enrollment : " + enrollment);


        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AActivity.class);
                startActivity(intent);
            }
        });
    }
}