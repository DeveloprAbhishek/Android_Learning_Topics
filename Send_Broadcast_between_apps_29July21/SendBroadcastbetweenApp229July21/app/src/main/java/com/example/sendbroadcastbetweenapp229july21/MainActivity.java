package com.example.sendbroadcastbetweenapp229july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BroadCastReceiver broadCastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiveBroadcast();
    }

    private void receiveBroadcast() {
        broadCastReceiver = new BroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.action.send_data_to_second_activity");
        registerReceiver(broadCastReceiver, intentFilter);
    }
}