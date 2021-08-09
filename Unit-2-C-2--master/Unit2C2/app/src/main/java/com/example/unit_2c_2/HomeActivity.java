package com.example.unit_2c_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private List<ResponseModel> covidList = new ArrayList<>();
    private CovidAdapter covidAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        callApi();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getPosts().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                covidList = response.body();
                setRecyclerAdapter();
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        covidAdapter = new CovidAdapter(covidList, this);
        recyclerView.setAdapter(covidAdapter);
    }

    @Override
    public void onLongClickListener(ResponseModel model, int position) {
        covidList.remove(model);
        covidAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClickListener() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.OpenLink");
        intent.setType("plain/text");
        intent.putExtra("url", "https://www.masaischool.com/");
        startActivity(intent);
    }
}