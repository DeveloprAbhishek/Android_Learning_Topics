package com.example.fragmentiiitotalapplecount03aug21;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {
    private Button mBtnBuy;
    private TextView mTvAppleAvailable;
    private EditText mEtAppleAvailable;
    private FragmentManager fragmentManager;
    private CommunicationListener communicationListener;
    private int totalApple;
    private int boughtApple;
    private int remainingApple;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.communicationListener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            this.boughtApple = getArguments().getInt("appleToBuy");
            this.totalApple = getArguments().getInt("totalApple");
            remainingApple = this.totalApple - this.boughtApple;
        } else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {
        mBtnBuy = view.findViewById(R.id.btnBuyApple);
        mTvAppleAvailable = view.findViewById(R.id.tvAppleAvailable);
        mEtAppleAvailable = view.findViewById(R.id.etEnterApple);

        mTvAppleAvailable.setText(remainingApple +"");

        mEtAppleAvailable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTvAppleAvailable.setText(s);
                String str = mTvAppleAvailable.getText().toString();
                totalApple = Integer.parseInt(str);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int totalApple = Integer.parseInt(mEtAppleAvailable.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("totalApple", totalApple);
                if (communicationListener != null && mEtAppleAvailable.getText().toString() != null) {
                    communicationListener.LaunchBuyApplesFragment(bundle);
                }
            }
        });
    }
}