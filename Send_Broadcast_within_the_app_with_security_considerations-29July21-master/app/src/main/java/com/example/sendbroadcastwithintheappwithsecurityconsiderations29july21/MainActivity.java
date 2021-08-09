package com.example.sendbroadcastwithintheappwithsecurityconsiderations29july21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSend;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(MainActivity.this, permissions, 110);

        mBtnSend = findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.action.send_data_to_second_activity");
                intent.putExtra("message", "I am from Activity One");
                sendBroadcast(intent, Manifest.permission.CAMERA);
            }
        });
        registerLocalReceiver();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 110:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Camera Permission granted.", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    Toast.makeText(MainActivity.this, "Camera is denied", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.action.send_data_to_second_activity");
        registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(localReceiver);
    }
}