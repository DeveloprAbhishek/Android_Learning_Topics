package com.example.complexpermissions06july21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Permission;
    private final int PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Permission = findViewById(R.id.btnPermission);
        Permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSION_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    displayToast("Camera and Storage permissions granted");
                } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_DENIED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])) {
                        displayToast("Camera granted , Storage denied");
                    } else {
                        displayToast("Camera granted , storage denied by selecting do not show again.");
                    }
                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                        displayToast("Storage granted , camera denied.");
                    } else {
                        displayToast("Storage granted, camera denied by selecting do not show again");
                    }
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])
                            && ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[1])) {
                        displayToast("Both the permissions denied");
                    } else {
                        displayToast("Storage denied by selecting do not show again and camera denied by selecting do not show again");
                    }
                }
                break;
        }
    }

    void displayToast(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}