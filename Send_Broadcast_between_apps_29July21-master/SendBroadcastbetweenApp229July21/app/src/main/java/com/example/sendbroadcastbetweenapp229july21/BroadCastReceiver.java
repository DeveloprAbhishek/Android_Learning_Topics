package com.example.sendbroadcastbetweenapp229july21;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "secondActivity", Toast.LENGTH_SHORT).show();
        Intent goToSecondActivity = new Intent(context, MainActivity2.class);
        String message = intent.getStringExtra("message");
        goToSecondActivity.putExtra("message", message);
        context.startActivity(goToSecondActivity);
    }
}
