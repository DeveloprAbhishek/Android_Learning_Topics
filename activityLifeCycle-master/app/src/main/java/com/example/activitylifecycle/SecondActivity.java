package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnGoThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAGSecondActivity", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnGoThirdActivity = findViewById(R.id.btnGoThirdActivity);

        btnGoThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAGSecondActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAGSecondActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAGSecondActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAGSecondActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAGSecondActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAGSecondActivity", "onDestroy");
    }
}