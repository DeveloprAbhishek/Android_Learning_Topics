package com.example.handlepermissioncheckbox06july21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button CameraPermission;
    private final int CAMERA_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CameraPermission = findViewById(R.id.btnCameraPermission);
        CameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_CODE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    displayToast("Camera Permission Granted");
                } else {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])) {
                        displayToast("Permission Denied!");
                    } else {
                        displayToast("Permission Denied by checking don't show again");
                    }
                }
                break;
        }
    }

    void displayToast(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}