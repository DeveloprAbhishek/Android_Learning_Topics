package com.example.fragment_iiievents03aug21.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment_iiievents03aug21.R;

public class TimeAndDateFragment extends Fragment {
    private Button mBtnNextPricePage;
    private EditText mEtStartDate, mEtEndDate, mEtStartTime, mEtEndTime;
    private CommunicationListener communicationListener;
    private String title, description;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            title = getArguments().getString("title");
            description = getArguments().getString("description");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtStartDate = view.findViewById(R.id.etStartDate);
        mEtEndDate = view.findViewById(R.id.etEndDate);
        mEtStartTime = view.findViewById(R.id.etStartTime);
        mEtEndTime = view.findViewById(R.id.etEndTime);
        mBtnNextPricePage = view.findViewById(R.id.btnNextPricePage);


        mBtnNextPricePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = mEtStartDate.getText().toString();
                String endDate = mEtEndDate.getText().toString();
                String startTime = mEtStartTime.getText().toString();
                String endTime = mEtEndTime.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);
                bundle.putString("startDate", startDate);
                bundle.putString("endDate", endDate);
                bundle.putString("startTime", startTime);
                bundle.putString("endTime", endTime);
                communicationListener.LaunchPriceDetailsFragment(bundle);
            }
        });
    }
}