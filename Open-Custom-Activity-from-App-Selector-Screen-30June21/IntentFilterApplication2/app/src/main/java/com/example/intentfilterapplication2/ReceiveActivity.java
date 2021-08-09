package com.example.intentfilterapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        name = findViewById(R.id.tvName);
        String nameOfPerson = getIntent().getStringExtra("name");
        name.setText(nameOfPerson.toString());
    }
}