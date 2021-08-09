package com.example.fragmentiiitotalapplecount03aug21;

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
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        transaction.add(R.id.container, totalApplesFragment, "totalAppleFragment").commit();
    }

    @Override
    public void LaunchBuyApplesFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        transaction.replace(R.id.container, buyApplesFragment, "buyFragment").addToBackStack("buyFragment").commit();
    }

    @Override
    public void LaunchTotalApplesFragment(Bundle bundle) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment = new TotalApplesFragment();
        totalApplesFragment.setArguments(bundle);
        transaction.replace(R.id.container, totalApplesFragment, "totalAppleFragment").addToBackStack("totalAppleFragment").commit();
    }


}