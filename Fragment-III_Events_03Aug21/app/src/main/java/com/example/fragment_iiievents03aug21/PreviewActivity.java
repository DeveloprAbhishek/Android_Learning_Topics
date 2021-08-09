package com.example.fragment_iiievents03aug21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private TextView mTvTitle, mTvDescription, mTvStartDate, mTvEndDate, mTvStartTime, mTvEndTime, mTvCurrency, mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tvTitle);
        mTvDescription = findViewById(R.id.tvDescription);
        mTvStartDate = findViewById(R.id.tvStartDate);
        mTvEndDate = findViewById(R.id.tvEndDate);
        mTvStartTime = findViewById(R.id.tvStartTime);
        mTvEndTime = findViewById(R.id.tvEndTime);
        mTvCurrency = findViewById(R.id.tvCurrency);
        mTvPrice = findViewById(R.id.tvPrice);

        EventModel model = (EventModel) getIntent().getSerializableExtra("model");
        mTvTitle.setText(model.getTitle());
        mTvDescription.setText(model.getDescription());;
        mTvStartDate.setText(model.getStartDate());
        mTvEndDate.setText(model.getEndDate());
        mTvStartTime.setText(model.getStartTime());
        mTvEndTime.setText(model.getEndTime());
        mTvCurrency.setText(model.getCurrency());
        mTvPrice.setText(model.getPrice()+"");
    }
}