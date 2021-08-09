package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }

    private void setRecyclerViewAdapter() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void buildRecyclerViewData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Aakash", "101", 22));
        studentList.add(new Student("Abhishek", "102", 23));
        studentList.add(new Student("Mukesh", "103", 24));
        studentList.add(new Student("Aakash", "101", 22));
        studentList.add(new Student("Abhishek", "102", 23));
        studentList.add(new Student("Mukesh", "103", 24));
        studentList.add(new Student("Aakash", "101", 22));
        studentList.add(new Student("Abhishek", "102", 23));
        studentList.add(new Student("Mukesh", "103", 24));
        studentList.add(new Student("Aakash", "101", 22));
        studentList.add(new Student("Abhishek", "102", 23));
        studentList.add(new Student("Mukesh", "103", 24));
        studentList.add(new Student("Aakash", "101", 22));
        studentList.add(new Student("Abhishek", "102", 23));
        studentList.add(new Student("Mukesh", "103", 24));

    }
}