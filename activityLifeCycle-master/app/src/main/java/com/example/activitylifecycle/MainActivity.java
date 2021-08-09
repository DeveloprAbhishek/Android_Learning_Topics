package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnToGOSecondPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAGMainActivity", "onCreate");

        btnToGOSecondPage = findViewById(R.id.btnGoSecondActivity);

        btnToGOSecondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAGMainActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAGMainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAGMainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAGMainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAGMainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAGMainActivity", "onDestroy");
    }
}