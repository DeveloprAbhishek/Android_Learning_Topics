package com.example.tiktok07aug21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText userName, password;
    private CheckBox rememberMe;
    private Button proceed;
    private static final String PREF_USERNAME_KEY = "PREF_STRING_KEY";
    boolean isCheckBoxChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        ifPreferenceDataAvailable();
    }

    private void ifPreferenceDataAvailable() {
        String username = PreferenceHelper.getStringFromPreference(LoginActivity.this, PREF_USERNAME_KEY);
        if(username != "Null") {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }


    }

    private void initViews() {
        userName = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        rememberMe = findViewById(R.id.cbRememberMe);
        proceed = findViewById(R.id.btnProceed);

        proceed.setOnClickListener(this);
        rememberMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnProceed) {
            if(isCheckBoxChecked) {
                PreferenceHelper.writeStringToPreference(LoginActivity.this, PREF_USERNAME_KEY, userName.getText().toString());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

        } else if (v.getId() == R.id.cbRememberMe) {
            isCheckBoxChecked = ((CheckBox) v).isChecked();
        }
    }
}