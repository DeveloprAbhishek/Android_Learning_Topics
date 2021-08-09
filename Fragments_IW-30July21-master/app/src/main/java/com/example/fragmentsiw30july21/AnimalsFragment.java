package com.example.fragmentsiw30july21;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AnimalsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Animal> animalList = new ArrayList<>();
    private AnimalAdapter animalAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildData();
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        animalAdapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(animalAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildData() {
        for (int i = 0; i < 10; i++) {
            animalList.add(new Animal(R.drawable.dog1, "Dog1"));
            animalList.add(new Animal(R.drawable.dog2, "Dog2"));
        }

    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}