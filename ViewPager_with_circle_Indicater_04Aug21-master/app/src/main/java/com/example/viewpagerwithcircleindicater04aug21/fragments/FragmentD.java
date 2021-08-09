package com.example.viewpagerwithcircleindicater04aug21.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpagerwithcircleindicater04aug21.R;

public class FragmentD extends Fragment {

    public FragmentD() {
        // Required empty public constructor
    }

    public static FragmentD newInstance() {
        FragmentD fragment = new FragmentD();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d, container, false);
    }
}