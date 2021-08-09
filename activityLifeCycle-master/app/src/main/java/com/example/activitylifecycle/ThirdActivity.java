package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAGThirdActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAGThirdActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAGThirdActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAGThirdActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAGThirdActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAGThirdActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAGThirdActivity", "onDestroy");
    }
}