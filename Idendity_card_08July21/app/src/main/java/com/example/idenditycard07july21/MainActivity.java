package com.example.idenditycard07july21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
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
        PersonAdapter personAdapter = new PersonAdapter(personList,this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(personAdapter);
    }

    private void buildRecyclerViewData() {
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 34, "Business", "Masai School"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 34, "Business", "Masai School"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.prateek_sukla, 34, "Business", "Masai School"));
        personList.add(new Person(R.drawable.jeff_bezos, 64, "Business", "Microsoft"));
        personList.add(new Person(R.drawable.bill_gates, 64, "Business", "Microsoft"));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }

    @Override
    public void onclickItem(Person person) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Person Details.")
                .setMessage(
                        person.getDesignation() + "\n"
                                + person.getAge()
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