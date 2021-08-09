package com.example.idenditycard07july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Person> personList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setDataToAdapter();
    }

    private void setDataToAdapter() {
        PersonAdapter personAdapter = new PersonAdapter(personList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personAdapter);
    }

    private void buildRecyclerViewData() {
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 56, "Business", "Amazon"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 56, "Business", "Amazon"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 56, "Business", "Amazon"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }
}