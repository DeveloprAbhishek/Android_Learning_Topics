package com.example.unit_2c_2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CovidViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvDate, mTvPositive, mTvNegative, mTvHospitalizedCurrently, mTvOnVentilatorCurrently, mTvDeath, mTvDateChecked;
    private CardView mCvCardView;
    private ItemClickListener itemClickListener;

    public CovidViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
        mTvNegative = itemView.findViewById(R.id.tvNegative);
        mTvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrently);
        mTvOnVentilatorCurrently = itemView.findViewById(R.id.tvOnVentilatorCurrently);
        mTvDeath = itemView.findViewById(R.id.tvOnDeath);
        mTvDateChecked = itemView.findViewById(R.id.tvDateChecked);
        mCvCardView = itemView.findViewById(R.id.itemCardView);

    }

    public void setData(ResponseModel responseModel) {
        String date =   getFormatDate(String.valueOf(responseModel.getDate())) ;
        String dateChecked = getDateChecked(String.valueOf(responseModel.getDateChecked()));
        mTvDate.setText(date);
        mTvPositive.setText(responseModel.getPositive() + "");
        mTvNegative.setText(responseModel.getNegative() + "");
        mTvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently() + "");
        mTvOnVentilatorCurrently.setText(responseModel.getOnVentilatorCurrently() + "");
        mTvDeath.setText(responseModel.getDeath() + "");
        mTvDateChecked.setText(dateChecked);

        mCvCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemClickListener.onLongClickListener(responseModel, getAdapterPosition());
                return true;
            }
        });

        mCvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickListener();
            }
        });
    }

    public String getFormatDate(String date) {
        String newDate = "";
        String year = "";
        String month = "";
        String Day = "";
        year = year + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
        month = month + date.charAt(4) + date.charAt(5);
        Day = Day + date.charAt(6) + date.charAt(7);
        newDate += year + "-" + month + "-" + Day;
        return newDate;
    }
    
    public String getDateChecked(String date) {
        String newDate = "";
        for (int i = 0; i < 10; i++) {
            newDate += date.charAt(i);
        }

        return newDate;
    }
}
