package com.example.intentsandintentfilterwepart30june21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etUserName, etPassword;
    private Button btnLogin;
    private final String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userName = isUserNameValid();
                boolean email = isEmailValid();
                boolean password = isPasswordValid();
                if (userName && email && password) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("userName", etUserName.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private boolean isEmailValid() {
        if (etEmail.getText().toString().length() > 0 && etEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            etEmail.setError("Email is inValid!");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (etPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            etPassword.setError("Password is invalid!");
            return false;
        }
    }

    private boolean isUserNameValid() {
        if (etUserName.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            etUserName.setError("Username is invalid!");
            return false;
        }
    }
}