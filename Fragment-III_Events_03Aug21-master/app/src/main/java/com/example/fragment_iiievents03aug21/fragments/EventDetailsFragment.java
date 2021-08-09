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

public class EventDetailsFragment extends Fragment {
    private Button mBtnNext;
    private EditText mEtTitle, mEtDescription;
    private CommunicationListener communicationListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnNextTime);
        mEtTitle = view.findViewById(R.id.etTitle);
        mEtDescription = view.findViewById(R.id.etDescription);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mEtTitle.getText().toString();
                String description = mEtDescription.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);

                communicationListener.LaunchTimeDateFragment(bundle);
            }
        });
    }
}