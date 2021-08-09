package com.example.threadswe_part05aug21;

import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class WorkerThread extends Thread {

    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler();
        Looper.loop();
    }

    public void addTaskToMessageQueue(Runnable task) {
        if (handler != null) {
            handler.post(task);
        }
    }

}
