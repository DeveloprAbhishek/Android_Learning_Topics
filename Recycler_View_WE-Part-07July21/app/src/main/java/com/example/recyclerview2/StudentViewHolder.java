package com.example.recyclerview2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {


    private TextView name, age, rollnumber;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        name = itemView.findViewById(R.id.tvName);
        age = itemView.findViewById(R.id.tvAge);
        rollnumber = itemView.findViewById(R.id.tvRollNo);
    }

    public void setData(Student studentList) {
        name.setText(studentList.getName());
        age.setText(studentList.getAge()+ "");
        rollnumber.setText(studentList.getRollno());
    }
}
