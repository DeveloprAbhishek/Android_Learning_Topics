package com.example.sendbroadcastwithintheappwithsecurityconsiderations29july21;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent activityIntent = new Intent(context, MainActivity2.class);
            String message = intent.getStringExtra("message");
            activityIntent.putExtra("message", message);

            context.startActivity(activityIntent);
        }
    }
}
