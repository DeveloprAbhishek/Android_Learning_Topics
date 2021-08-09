package com.example.unit_2c_2secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mWebView = findViewById(R.id.webView);
        if(getIntent() != null) {
            String url = getIntent().getStringExtra("url");
            mWebView.loadUrl(url);
        }
    }
}