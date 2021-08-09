package com.example.eventbookingsharedpreferenceyoupart06july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String FIRST_NAME_KEY = "FIRST_NAME", LAST_NAME_KEY = "LAST_NAME", EMAIL_KEY = "EMAIL", PHONE_KEY = "PHONE";
    EditText firstName, lastName, emailAddress, phoneNumber;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        emailAddress = findViewById(R.id.etEmailAddress);
        phoneNumber = findViewById(R.id.etPhoneNumber);
        next = findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceHelper.writeStringToPreference(MainActivity.this, FIRST_NAME_KEY, firstName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this, LAST_NAME_KEY, lastName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this, EMAIL_KEY, emailAddress.getText().toString());
                PreferenceHelper.writeIntToPreference(MainActivity.this, PHONE_KEY, Integer.parseInt(phoneNumber.getText().toString()));

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}