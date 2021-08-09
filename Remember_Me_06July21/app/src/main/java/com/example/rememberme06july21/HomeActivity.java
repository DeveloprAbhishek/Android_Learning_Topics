package com.example.rememberme06july21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView Username;
    private static final String PREF_USERNAME_KEY = "PREF_STRING_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Username = findViewById(R.id.tvUserName);
        String username = PreferenceHelper.getStringFromPreference(HomeActivity.this, PREF_USERNAME_KEY);
        Username.setText(username);
    }
}