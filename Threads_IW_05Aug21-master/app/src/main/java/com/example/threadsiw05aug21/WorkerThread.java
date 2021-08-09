package com.example.threadsiw05aug21;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class WorkerThread extends Thread{
    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler();
        Looper.loop();
    }

    void addTaskToMessageQueue(Runnable task) {
        if(handler != null) {
            handler.post(task);
        }
    }

}
