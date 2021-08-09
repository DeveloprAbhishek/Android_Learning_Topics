package com.example.viewpagerwithtabs04aug21;

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
import java.util.Collections;
import java.util.List;

public class FragmentC extends Fragment {
    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildListData();
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(list);
        recyclerView.setAdapter(itemAdapter);
    }

    private void buildListData() {
        String[] arr = {"munnar","coalkers walk","love lake","abhey falls", "Red Fort", "Nahargarh Fort", "Jal Mahal", "Taj Mahal", "Connaught Place", "Hawa Mahal", "Raj Ghat"};
        Collections.addAll(list, arr);
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();
    }
}