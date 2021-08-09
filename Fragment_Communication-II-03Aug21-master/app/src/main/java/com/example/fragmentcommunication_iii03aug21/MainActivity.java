package com.example.fragmentcommunication_iii03aug21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener{
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment studentPersonalDetailsFragment = new StudentPersonalDetailsFragment();
        transaction.add(R.id.container, studentPersonalDetailsFragment, "personal").commit();
    }

    @Override
    public void LaunchPerformanceFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment detailsFragment = new StudentPerformanceDetailsFragment();
        detailsFragment.setArguments(bundle);
        transaction.replace(R.id.container, detailsFragment, "personalDetailFragment").addToBackStack("detailsFragment").commit();
    }
}