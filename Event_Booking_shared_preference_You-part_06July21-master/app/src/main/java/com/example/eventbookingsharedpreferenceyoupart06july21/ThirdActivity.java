package com.example.eventbookingsharedpreferenceyoupart06july21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private static final String FIRST_NAME_KEY = "FIRST_NAME", LAST_NAME_KEY = "LAST_NAME", EMAIL_KEY = "EMAIL", PHONE_KEY = "PHONE";
    private static final String NUMBER_OF_SEATS_KEY = "NUMBER_OF_SEATS", DATE_OF_SHOW_KEY = "DATE_OF_SHOW";
    EditText numberOfSeat, dateOfShow, firstName, lastName, emailAddress, phoneNumber;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initViews();
        getDataFromSharedPreference();
    }

    private void initViews() {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        emailAddress = findViewById(R.id.etEmailAddress);
        phoneNumber = findViewById(R.id.etPhoneNumber);

        numberOfSeat = findViewById(R.id.etNoOfSeats);
        dateOfShow = findViewById(R.id.etDateOfShow);
        confirm = findViewById(R.id.btnConfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ThirdActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("The event is confirmed on " + dateOfShow.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                            }
                        })
                        .show();
            }
        });
    }

    private void getDataFromSharedPreference() {
        String fName = PreferenceHelper.getStringFromPreference(ThirdActivity.this, FIRST_NAME_KEY);
        String lName = PreferenceHelper.getStringFromPreference(ThirdActivity.this, LAST_NAME_KEY);
        String email = PreferenceHelper.getStringFromPreference(ThirdActivity.this, EMAIL_KEY);
        int phone = PreferenceHelper.getIntFromPreference(ThirdActivity.this, PHONE_KEY);
        int noOfSeats = PreferenceHelper.getIntFromPreference(ThirdActivity.this, NUMBER_OF_SEATS_KEY);
        String date_of_Show = PreferenceHelper.getStringFromPreference(ThirdActivity.this, DATE_OF_SHOW_KEY);

        firstName.setText(fName);
        lastName.setText(lName);
        emailAddress.setText(email);
        phoneNumber.setText("" + phone);
        numberOfSeat.setText("" + noOfSeats);
        dateOfShow.setText(date_of_Show);
    }
}