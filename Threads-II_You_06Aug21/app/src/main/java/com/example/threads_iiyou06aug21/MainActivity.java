package com.example.threads_iiyou06aug21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSaveUser;
    private TextView mTvName;
    private EditText mEtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBtnSaveUser = findViewById(R.id.btnSaveUser);
        mTvName = findViewById(R.id.tvName);
        mEtUserName = findViewById(R.id.etUserName);

        mBtnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUserName.getText().toString();
                if(!userName.equals("")) {
                    asyncTask.execute(userName);
                } else {
                    Toast.makeText(MainActivity.this, "Please Enter UserName", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {
        @Override
        protected String doInBackground(String... strings) {
            Log.d("Abhishek", "doInBackground "+strings[0]);
            saveLogsToFile(strings[0]);
            String name = readFile();
            return name;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Abhishek", "onPostExecute" + s);
            mTvName.setText(s);
        }
    };


    private void saveLogsToFile(String message) {
        try {
            File directory = new File(getFilesDir() + File.separator + "UserNames");
            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(directory, "user.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
            writer.append(message + "\n");
            writer.close();
            updateUI();
        } catch (Exception e) {
            Log.d("Abhishek", e.getLocalizedMessage());
        }
    }

    private void updateUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "UserName successfully saved in File", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String readFile() {
        try {
            File directory = new File(getFilesDir() + File.separator + "UserNames");

            File file = new File(directory, "user.txt");
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            StringBuilder stringBuilder = new StringBuilder();
            while (data != -1) {
                char ch = (char) data;
                stringBuilder.append(ch);
                data = inputStreamReader.read();
            }
            return stringBuilder.toString();
            //UpdateReadData(stringBuilder);
        } catch (Exception e) {
            return "no User";
        }
    }

}