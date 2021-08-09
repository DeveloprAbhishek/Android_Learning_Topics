package com.example.recyclerview_ii_we_08july21;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    ArrayList<Student> studentArrayList;
    private ItemClickListener itemClickListener;
    public StudentAdapter(ArrayList<Student> studentArrayList, ItemClickListener itemClickListener) {
        this.studentArrayList = studentArrayList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new StudentViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentArrayList.get(position);
        holder.setData(student);
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }
}
