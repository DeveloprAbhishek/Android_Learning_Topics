package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, cc, content;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.btnSend);
        content = findViewById(R.id.etContent);
        email = findViewById(R.id.etEmail);
        cc = findViewById(R.id.etCc);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = cc.getText().toString().split(",");

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, content.getText().toString());
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                sendIntent.putExtra(Intent.EXTRA_CC, arr);

                sendIntent.setType("message/rfc822");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });
    }
}