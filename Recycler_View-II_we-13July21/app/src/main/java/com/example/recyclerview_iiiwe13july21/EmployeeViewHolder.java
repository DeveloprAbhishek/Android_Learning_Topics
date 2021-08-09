package com.example.recyclerview_iiiwe13july21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView name, salary, age;
    private CardView itemCardView;
    private ItemClickListener itemClickListener;

    public EmployeeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        name = itemView.findViewById(R.id.tvName);
        age = itemView.findViewById(R.id.tvAge);
        salary = itemView.findViewById(R.id.tvSalary);
        itemCardView = itemView.findViewById(R.id.itemCardView);
    }

    public void setData(Employee employee) {
        name.setText(employee.getName().toString());
        age.setText(employee.getAge()+"");
        salary.setText(employee.getSalary()+"");
        itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), employee);
            }
        });
    }
}
