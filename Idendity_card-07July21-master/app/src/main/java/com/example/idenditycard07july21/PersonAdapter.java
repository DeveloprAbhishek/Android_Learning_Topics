package com.example.idenditycard07july21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonAdapter extends RecyclerView.Adapter<PersonHolder> {
    ArrayList<Person> personArrayList;
    public PersonAdapter(ArrayList<Person> personList) {
        personArrayList = personList;
    }

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder holder, int position) {
        Person person = personArrayList.get(position);
        holder.setViewData(person);
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}
