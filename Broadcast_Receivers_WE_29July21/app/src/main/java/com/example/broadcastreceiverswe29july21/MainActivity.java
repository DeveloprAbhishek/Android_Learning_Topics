package com.example.broadcastreceiverswe29july21;

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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button mBtnSend;
    TextView mTvData;
    LocalBroadcastManager localBroadcastManager;
    LocalReceiver localReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerLocalReceiver();

    }

    private void initViews() {
        mBtnSend = findViewById(R.id.btnSend);
        mTvData = findViewById(R.id.tvData);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcast");
                intent.putExtra("data", "Hello Masai School");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registerLocalReceiver() {
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.broadcast");
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }


    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent != null) {
                String data = intent.getStringExtra("data");
                mTvData.setText(data);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }
}