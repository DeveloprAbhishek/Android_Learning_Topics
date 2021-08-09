package com.example.analysethefragmenttransactionmethods02aug21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnBtnAddA;
    private Button mBtnBtnRemoveA;
    private Button mBtnReplaceAWithBWithoutBackstack;
    private Button mBtnReplaceAWithB;
    private Button mBtnAddB, mBtnRemoveB, mBtnReplaceBWithA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        fragmentManager = getSupportFragmentManager();

    }

    private void initviews() {
        mBtnBtnAddA = findViewById(R.id.btnAddA);
        mBtnBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnReplaceAWithBWithoutBackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceAWithB = findViewById(R.id.btnReplaceAWithB);

        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnRemoveB.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);

        mBtnBtnAddA.setOnClickListener(this);
        mBtnReplaceAWithB.setOnClickListener(this);
        mBtnBtnRemoveA.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackstack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnAddA:
                addA();
                break;

            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnReplaceAWithB:
                replaceAWithBWithBackstack();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAWithB();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
        }
    }

    private void replaceAWithBWithBackstack() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").addToBackStack("fragB").commit();
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("fragmentA");
        if(fragmentA != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("fragmentB");
        if(fragmentB != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.replace(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

    private void replaceAWithB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.replace(R.id.flContainer, fragmentB, "fragmentB").commit();
    }

    void addA() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        transaction.add(R.id.flContainer, fragmentA, "fragmentA").commit();
    }

    void addB() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        transaction.add(R.id.flContainer, fragmentB, "fragmentB").commit();
    }
}