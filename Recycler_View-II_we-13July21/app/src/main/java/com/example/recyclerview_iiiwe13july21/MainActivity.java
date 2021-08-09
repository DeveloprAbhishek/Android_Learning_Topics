package com.example.recyclerview_iiiwe13july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView mRecyclerView;
    private CardView mCardView;
    private Button mBtnDone;
    private EditText mName, mAge, mSalary;
    private ArrayList<Employee> employeeData = new ArrayList<>();
    private EmployeeAdapter employeeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        employeeAdapter = new EmployeeAdapter(employeeData, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(employeeAdapter);
    }

    private void buildRecyclerViewData() {
        employeeData.add(new Employee("Abhishek", 88000.00, 22));
        employeeData.add(new Employee("Aakash", 64240.40, 24));
        employeeData.add(new Employee("Amol", 34067.65, 25));
        employeeData.add(new Employee("Rakesh", 68000.98, 21));
        employeeData.add(new Employee("Abhinav", 58000.43, 23));
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mCardView = findViewById(R.id.editCardView);
        mBtnDone = findViewById(R.id.btnDone);
        mName = findViewById(R.id.etName);
        mAge = findViewById(R.id.etAge);
        mSalary = findViewById(R.id.etSalary);
    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mName.setText(employee.getName());
        mAge.setText(employee.getAge()+"");
        mSalary.setText(employee.getSalary()+"");
        mCardView.setVisibility(View.VISIBLE);

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardView.setVisibility(View.GONE);
                Employee updated_employee = new Employee(mName.getText().toString(),
                        Double.parseDouble(mSalary.getText().toString()), Integer.parseInt(mAge.getText().toString()));
                employeeData.set(position, updated_employee);
                employeeAdapter.notifyItemChanged(position);
            }
        });
    }
}