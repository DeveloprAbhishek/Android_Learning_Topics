package com.example.idenditycard07july21;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class PersonHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView age, profession, designation;
    ConstraintLayout constraintLayout;
    private ItemClickListener itemClickListener;

    public PersonHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        image = itemView.findViewById(R.id.ivPersonImage);
        age = itemView.findViewById(R.id.tvPersonAge);
        profession = itemView.findViewById(R.id.tvPersonProfession);
        designation = itemView.findViewById(R.id.tvPersonDesignation);
        constraintLayout = itemView.findViewById(R.id.identityCard);
    }

    public void setViewData(Person person) {
        image.setImageResource(person.getImage());
        age.setText(person.getAge()+"");
        profession.setText(person.getProfession());
        designation.setText(person.getDesignation());
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onclickItem(person);
            }
        });
    }
}
