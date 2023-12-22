package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntent extends AppCompatActivity {

    EditText et_url;
    Button btn_openurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        et_url = (EditText) findViewById(R.id.et_url);
        btn_openurl = (Button) findViewById(R.id.btn_openurl);

        btn_openurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=et_url.getText().toString();

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}