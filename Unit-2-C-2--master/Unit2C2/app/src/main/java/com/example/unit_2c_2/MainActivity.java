package com.example.unit_2c_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String EMAIL_KEY = "EMAIL_KEY";
    private static final String PASSWORD_KEY = "PASSWORD_KEY";
    private static final String EMAIL_VALIDATION = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private EditText mEtEmail, mEtPassword;
    private Button mBtnLogin;
    private CheckBox mCBRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSharedPreferenceData();
        initViews();
    }

    private void getSharedPreferenceData() {
        String email = PreferenceHelper.getStringFromPreference(MainActivity.this, EMAIL_KEY);
        String password = PreferenceHelper.getStringFromPreference(MainActivity.this, PASSWORD_KEY);
        if(email != null && password != null) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
        mCBRemember = findViewById(R.id.cbRemember);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCBRemember.isChecked()) {
                    PreferenceHelper.writeStringToPreference(MainActivity.this, EMAIL_KEY, mEtEmail.getText().toString());
                    PreferenceHelper.writeStringToPreference(MainActivity.this, PASSWORD_KEY, mEtPassword.getText().toString());
                }
                boolean emailValid = isEmailValid();
                boolean passwordValid = isPasswordValid();

                if(emailValid && passwordValid) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean isEmailValid() {
        if(mEtEmail.getText().toString().matches(EMAIL_VALIDATION)) {
            return true;
        } else {
            mEtEmail.setError("Invalid Email!");
            return false;
        }
    }

    public boolean isPasswordValid() {
        if(mEtPassword.getText().toString().length()>=6) {
            return true;
        } else {
            mEtPassword.setError("Password is very short!");
            return false;
        }
    }
}