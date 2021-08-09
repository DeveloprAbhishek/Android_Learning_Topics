package com.example.sprint2coding05july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {
    private EditText name, password;
    private Button signIn;
    private TextView signUp, showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initViews();
        showPasswordWhenEnters();
    }

    private void showPasswordWhenEnters() {
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                showPassword.setText(s.toString());
            }
        });
    }

    private void initViews() {
        name = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        signIn = findViewById(R.id.btnSignIn);
        signUp = findViewById(R.id.tvSignUp);

        showPassword = findViewById(R.id.tvShowPassword);
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnSignIn) {
            boolean nameValid = isNameValidate();
            boolean passwordValid = isPasswordValidate();

            if(nameValid && passwordValid) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                intent.putExtra("username", name.getText().toString());
                startActivity(intent);
            }
        } else if(id == R.id.tvSignUp) {
            Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
            startActivity(intent);
        }
    }

    boolean isNameValidate() {
        if(name.getText().length() >= 4) {
            return true;
        } else {
            name.setError("Minimum 4 Character Needed!");
            return false;
        }
    }

    boolean isPasswordValidate() {
        if(password.getText().length() >= 6) {
            return true;
        } else {
            password.setError("Password is Weak!");
            return false;
        }
    }
}