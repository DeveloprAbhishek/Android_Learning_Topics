package com.example.dynamicfragments02aug21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction =fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.replace(R.id.flContainer, fragmentA, "fragmentA").commit();
    }
}   