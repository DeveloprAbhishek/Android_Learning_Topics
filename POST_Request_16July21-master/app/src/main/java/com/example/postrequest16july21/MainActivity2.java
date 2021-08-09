package com.example.postrequest16july21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView mTvEmail, mTvPassword,mTvTitle, mTVRequestType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
    }

    private void initViews() {
        mTvEmail = findViewById(R.id.tvEmail);
        mTvPassword = findViewById(R.id.tvPassword);
        mTvTitle = findViewById(R.id.tvTitle);
        mTVRequestType = findViewById(R.id.tvRequestType);

        mTvEmail.setText(getIntent().getStringExtra("email"));
        mTvPassword.setText(getIntent().getStringExtra("password"));
        mTvTitle.setText(getIntent().getStringExtra("title"));
        mTVRequestType.setText(getIntent().getStringExtra("requestType"));
    }
}