package com.example.fragmentcommunication_iii03aug21;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class StudentPerformanceDetailsFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtGrade, mEtPercentage;
    private String name;
    private int age;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            name = getArguments().getString("name");
            age = getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_performance_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnPreview);
        mEtGrade = view.findViewById(R.id.etStudentGrade);
        mEtPercentage = view.findViewById(R.id.etStudentPercentage);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = mEtGrade.getText().toString();
                String percentage = mEtPercentage.getText().toString();
                Intent intent  =new Intent(getActivity(), PreviewActivity.class);
                Model model = new Model(name, grade, percentage, age);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
    }
}