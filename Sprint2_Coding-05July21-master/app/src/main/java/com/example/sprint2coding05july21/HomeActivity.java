package com.example.sprint2coding05july21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView showUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showUserName = findViewById(R.id.tvDisplayUserName);
        String  userName = getIntent().getStringExtra("username");
        showUserName.setText(userName);
    }
}