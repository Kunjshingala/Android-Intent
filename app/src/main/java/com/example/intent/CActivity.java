package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cactivity);

        mTextViewResult = findViewById(R.id.result);
        mEditTextNumber1 = findViewById(R.id.input_number1);
        mEditTextNumber2 = findViewById(R.id.input_number2);

        Button button_open_activity2 = findViewById(R.id.button_open_activity2);
        button_open_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditTextNumber1.getText().toString().equals("") || mEditTextNumber2.getText().toString().equals("")) {
                    Toast.makeText(CActivity.this, "Enter number", Toast.LENGTH_SHORT).show();
                } else {
                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    Intent intent = new Intent(CActivity.this, DActivity.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
//            Log.d("ResultError", "Result returned" + result);
            mTextViewResult.setText("Result : " + String.valueOf(result));
        }
        if (resultCode == RESULT_CANCELED) {
            mTextViewResult.setText("Nothing selected");
        }
    }
}