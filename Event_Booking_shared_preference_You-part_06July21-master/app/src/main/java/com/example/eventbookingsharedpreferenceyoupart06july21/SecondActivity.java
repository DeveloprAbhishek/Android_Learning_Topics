package com.example.eventbookingsharedpreferenceyoupart06july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private static final String FIRST_NAME_KEY = "FIRST_NAME", LAST_NAME_KEY = "LAST_NAME", EMAIL_KEY = "EMAIL", PHONE_KEY = "PHONE";
    private static final String NUMBER_OF_SEATS_KEY = "NUMBER_OF_SEATS", DATE_OF_SHOW_KEY = "DATE_OF_SHOW";
    EditText numberOfSeat, dateOfShow, firstName, lastName, emailAddress;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        getDataFromSharedPreference();

    }

    private void initViews() {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        emailAddress = findViewById(R.id.etEmailAddress);

        numberOfSeat = findViewById(R.id.etNoOfSeats);
        dateOfShow = findViewById(R.id.etDateOfShow);
        next = findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceHelper.writeIntToPreference(SecondActivity.this,NUMBER_OF_SEATS_KEY,Integer.parseInt(numberOfSeat.getText().toString()));
                PreferenceHelper.writeStringToPreference(SecondActivity.this,DATE_OF_SHOW_KEY,dateOfShow.getText().toString());

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getDataFromSharedPreference() {
        String fName = PreferenceHelper.getStringFromPreference(SecondActivity.this, FIRST_NAME_KEY);
        String lName = PreferenceHelper.getStringFromPreference(SecondActivity.this, LAST_NAME_KEY);
        String email = PreferenceHelper.getStringFromPreference(SecondActivity.this, EMAIL_KEY);
        firstName.setText(fName);
        lastName.setText(lName);
        emailAddress.setText(email);
    }
}