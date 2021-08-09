package com.example.eventlistenersandsaveuistatesipart29june21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnEnter;
    private  EditText editText;
    private TextView textView;
    private String enteredText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>6) {
                    Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    enteredText = s.toString();
                }
            }
        });
        
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(enteredText);
                Toast.makeText(MainActivity.this, "ButtonClicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        btnEnter = findViewById(R.id.btnEnter);
        editText = findViewById(R.id.etEnterText);
        textView = findViewById(R.id.tv);
    }


}