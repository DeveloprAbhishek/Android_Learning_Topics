package com.example.fragmentiiitotalapplecount03aug21;

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
import android.widget.Toast;

public class BuyApplesFragment extends Fragment {
    private EditText mEtEnterAppleToBuy;
    private Button mBtnGoBack;
    private CommunicationListener communicationListener;
    private int totalApple;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            totalApple = getArguments().getInt("totalApple");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtEnterAppleToBuy = view.findViewById(R.id.etEnterAppleToBuy);
        mBtnGoBack = view.findViewById(R.id.btnBack);

        mBtnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int appleToBuy = Integer.parseInt(mEtEnterAppleToBuy.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("appleToBuy", appleToBuy);
                bundle.putInt("totalApple", totalApple);
                if(appleToBuy <= totalApple) {
                    communicationListener.LaunchTotalApplesFragment(bundle);
                } else {
                    Toast.makeText(getContext(), "Apple is not in sufficient quantity!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}