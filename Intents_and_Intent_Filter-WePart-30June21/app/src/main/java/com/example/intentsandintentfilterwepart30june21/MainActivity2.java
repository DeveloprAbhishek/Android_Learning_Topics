package com.example.intentsandintentfilterwepart30june21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvShowUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvShowUserName = findViewById(R.id.tvShowUserName);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        tvShowUserName.setText(userName);
    }
}