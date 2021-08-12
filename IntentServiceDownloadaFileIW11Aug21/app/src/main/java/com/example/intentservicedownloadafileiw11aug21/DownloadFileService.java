package com.example.intentservicedownloadafileiw11aug21;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadFileService extends IntentService {

    public DownloadFileService() {
        super("name");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        downloadFile();
    }


    private void downloadFile() {
        try {
            File directory = new File(getFilesDir() + File.separator + "MyFiles");

            if(!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(directory, "file.html");

            if(!file.exists()) {
                file.createNewFile();
            }

            URL url = new URL("https://www.vogella.com/index.html");
            InputStream inputStream = url.openConnection().getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);

            int data = inputStreamReader.read();
            while(data != -1) {
                char ch = (char) data;
                fileOutputStream.write(ch);
                data = inputStreamReader.read();
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            int fileData = fileInputStream.read();
            StringBuffer stringBuffer = new StringBuffer();

            while (fileData != -1) {
                char ch = (char) fileData;
                stringBuffer = stringBuffer.append(ch);
                fileData = fileInputStream.read();
            }

            Intent intent = new Intent("com.android.broadcast_receiver");
            intent.putExtra("WebData", stringBuffer.toString());
            sendBroadcast(intent);

            Log.d("Abhishek", stringBuffer.toString());
        }catch (Exception e) {

        }

    }
}