package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        EditText input_ms = findViewById(R.id.input_ms);
        TextView time_result = findViewById(R.id.time_result);

        String milliSecond = String.valueOf(System.currentTimeMillis());

        input_ms.setText(milliSecond);

        findViewById(R.id.btn_convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long millitime = Long.parseLong(input_ms.getText().toString());

                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss:ms a", Locale.getDefault());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

                String date = simpleDateFormat.format(millitime);
                String time = simpleTimeFormat.format(millitime);


                time_result.setText(date + ", " + time);
            }
        });
    }
}