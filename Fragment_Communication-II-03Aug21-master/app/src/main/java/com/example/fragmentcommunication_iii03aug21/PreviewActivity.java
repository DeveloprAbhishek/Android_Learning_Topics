package com.example.fragmentcommunication_iii03aug21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private TextView mTvName, mTvGrade, mTvPercentage, mTvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
    }

    private void initViews() {
        mTvName = findViewById(R.id.tvStudentName);
        mTvGrade = findViewById(R.id.tvStudentGrade);
        mTvPercentage = findViewById(R.id.tvStudentPercentage);
        mTvAge = findViewById(R.id.tvStudentAge);

        if(getIntent() != null) {
            Model model = (Model) getIntent().getSerializableExtra("model");
            mTvName.setText(model.getName());
            mTvAge.setText(model.getAge()+"");
            mTvGrade.setText(model.getGrade());
            mTvPercentage.setText(model.getPercentage());
        }
    }
}