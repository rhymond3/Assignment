package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        textView = findViewById(R.id.textView2);
        Integer result= intent.getExtras().getInt("result");
        textView.setText(String.valueOf(result));
    }

    public void back(View view) {
        finish();
        //moveTaskToBack(true);
    }
}
