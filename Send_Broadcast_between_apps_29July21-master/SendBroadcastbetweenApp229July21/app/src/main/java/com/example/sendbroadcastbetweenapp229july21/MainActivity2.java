package com.example.sendbroadcastbetweenapp229july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView mTvTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvTextView = findViewById(R.id.textView);
        mTvTextView.setText(getIntent().getStringExtra("message"));
    }
}