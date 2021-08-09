package com.example.getresourcesapi15july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtNumber;
    private Button mBtnFetchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtNumber = findViewById(R.id.etNumber);
        mBtnFetchData = findViewById(R.id.btnFetchData);

        mBtnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("num", Integer.parseInt(mEtNumber.getText().toString()));
                startActivity(intent);
            }
        });
    }
}