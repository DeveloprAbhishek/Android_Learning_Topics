package com.example.fragment_iiievents03aug21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragment_iiievents03aug21.fragments.CommunicationListener;
import com.example.fragment_iiievents03aug21.fragments.EventDetailsFragment;
import com.example.fragment_iiievents03aug21.fragments.PriceDetailsFragment;
import com.example.fragment_iiievents03aug21.fragments.TimeAndDateFragment;

public class MainActivity extends AppCompatActivity  implements CommunicationListener {
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        transaction.add(R.id.container, eventDetailsFragment, "eventDetailsFragment").commit();
    }

    @Override
    public void LaunchTimeDateFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        transaction.add(R.id.container, timeAndDateFragment, "timeAndDateFragment").commit();
    }

    @Override
    public void LaunchPriceDetailsFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        transaction.add(R.id.container, priceDetailsFragment, "priceDetailsFragment").commit();
    }

}