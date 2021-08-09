package com.example.recyclerview_ii_we_08july21;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView age, address, name, dob;
    ImageView image;
    RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;
    public StudentViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        age = itemView.findViewById(R.id.tvAge);
        name = itemView.findViewById(R.id.tvAge);
        address = itemView.findViewById(R.id.tvAge);
        dob = itemView.findViewById(R.id.tvAge);
        image = itemView.findViewById(R.id.ivStudentImg);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);

    }

    public void setData(Student student) {
        age.setText(student.getAge()+"");
        name.setText(student.getName());
        image.setImageResource(student.getImageId());
        dob.setText(student.getDob());
        address.setText(student.getAddress());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(student);
            }
        });
    }
}
