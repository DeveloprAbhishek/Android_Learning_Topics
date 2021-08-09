package com.example.threads_iiiw06aug21;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

public class WorkerThread extends HandlerThread {
    private Handler mainThreadHandler;
    public WorkerThread(String name, Handler mainThreadHandler) {
        super(name);
        this.mainThreadHandler = mainThreadHandler;
    }


    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                progress = progress + 10;
                Log.d("WorkerThread-1", ""+progress);
                Message message = Message.obtain();
                message.obj = progress;
                mainThreadHandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
