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
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, email, password;
    private Button signUp;
    private TextView signIn, showPassword;
    private final String emailValidationString = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        signIn = findViewById(R.id.tvSignIn);
        signUp = findViewById(R.id.btnSignUp);
        showPassword = findViewById(R.id.tvShowPassword);
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
       if(id == R.id.btnSignUp) {
            boolean emailValid = isEmailValidate();
            boolean nameValid = isNameValidate();
            boolean passwordValid = isPasswordValidate();

            if(emailValid && nameValid && passwordValid) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                intent.putExtra("username", name.getText().toString());
                startActivity(intent);
            }
       } else if(id == R.id.tvSignIn) {
           Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
           startActivity(intent);
       }
    }

    boolean isEmailValidate() {
        if(email.getText().toString().matches(emailValidationString) && email.getText().toString().length() > 0) {
            return true;
        } else {
            email.setError("Invalid email!");
            return false;
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