package com.example.recyclerview_ii_we_08july21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView recyclerView;
    private final ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildDataForRecyclerView();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void buildDataForRecyclerView() {
        for (int i = 0; i < 100; i++) {
            studentList.add(new Student("abhishek",
                    "ward no. 45, ajay nagar, jaipur, Rajasthan",
                    "20-07-1999", R.drawable.jeff_bezos_1, 22));
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClick(Student student) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage(
                        student.getName() + "\n"
                                + student.getAge() + "\n"
                                + student.getDob() + "\n"
                                + student.getAddress()
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();
    }
}