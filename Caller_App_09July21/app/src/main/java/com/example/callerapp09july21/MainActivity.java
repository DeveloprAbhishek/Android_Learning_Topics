package com.example.callerapp09july21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private TextView mTvTextView;
    private ArrayList<ContactModel> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildContactList();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ContactAdapter contactAdapter = new ContactAdapter(list, this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(contactAdapter);
    }

    private void buildContactList() {
        for (int i = 0; i < 5; i++) {
            list.add(new ContactModel("Abhishek", "7777011329"));
            list.add(new ContactModel("Abhi", "7988138681"));
            list.add(new ContactModel("aakash", "9988998877"));
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mTvTextView = findViewById(R.id.tvTextView);

        String[] permissions = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(MainActivity.this, permissions, 110);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 110:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Contact Permission granted.", Toast.LENGTH_SHORT).show();
                    recyclerView.setVisibility(View.VISIBLE);
                    mTvTextView.setVisibility(View.GONE);
                    setAdapter();
                    break;
                } else {
                    Toast.makeText(MainActivity.this, "Contact Permission is denied", Toast.LENGTH_SHORT).show();
                    recyclerView.setVisibility(View.GONE);
                    mTvTextView.setVisibility(View.VISIBLE);
                }
        }
    }

    @Override
    public void onClickContact(ContactModel contact) {
        Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show();
        String phone = contact.getNumber();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}