package com.example.receivenameandageyou29july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTvAge, mTvName;
    private Button mBtnSend;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerLocalReceiver();
    }

    private void initViews() {
        mTvAge = findViewById(R.id.tvAge);
        mTvName = findViewById(R.id.tvName);
        mBtnSend = findViewById(R.id.btnSend);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.action.send_age_name");
                intent.putExtra("name", "abhishek");
                intent.putExtra("age", "22");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.action.send_age_name");
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    private class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null) {
                String name = intent.getStringExtra("name");
                String age = intent.getStringExtra("age");
                mTvAge.setText(age);
                mTvName.setText(name);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localReceiver);
    }
}