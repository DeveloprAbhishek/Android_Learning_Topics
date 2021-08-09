package com.example.taskmanagement03july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView loginText;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        loginText = findViewById(R.id.tvLoginText);
        createAccount = findViewById(R.id.btnCreateAccount);

        createAccount.setOnClickListener(this);
        loginText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCreateAccount) {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        } else if(v.getId() == R.id.tvLoginText) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}