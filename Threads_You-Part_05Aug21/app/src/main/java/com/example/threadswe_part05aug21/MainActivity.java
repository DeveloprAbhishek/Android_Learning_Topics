package com.example.threadswe_part05aug21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private Button mTvBtnStartProcess;
    private ProgressBar progressBar;
    private WorkerThread workerThread;
    private Handler mainHandler;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mTvBtnStartProcess = findViewById(R.id.btnStartProcess);
        progressBar = findViewById(R.id.progressBar);
        workerThread = new WorkerThread();
        workerThread.start();

        mTvBtnStartProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(Task);
            }
        });
    }



    private Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int progress = (int) msg.obj;
            progressBar.setProgress(progress);
        }
    };

    private Runnable Task = new Runnable() {
        @Override
        public void run() {

            int progress = 0;
            for (int i = 0; i < 10; i++) {
                progress = progress + 10;
                Log.d("Thread-1", "Value:= " + progress);
                Message message = Message.obtain();
                message.obj = progress;
                mainThreadHandler.sendMessage(message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}