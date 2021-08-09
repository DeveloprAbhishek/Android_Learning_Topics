package com.example.viewpagerwithcircleindicater04aug21.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewpagerwithcircleindicater04aug21.R;

public class FragmentA extends Fragment {

    public FragmentA() {
    }

    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

}