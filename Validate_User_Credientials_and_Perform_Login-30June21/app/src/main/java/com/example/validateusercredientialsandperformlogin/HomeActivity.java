package com.example.validateusercredientialsandperformlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView showEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showEmail = findViewById(R.id.tvEmail);
        String email = getIntent().getStringExtra("email");
        showEmail.setText(email);
    }
}