package com.example.openwebsiteinactivity02july21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView1);
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.masaischool.com/");
    }
}