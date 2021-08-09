package com.example.retrofitiiwe16july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText mEtPostId;
    private Button mBtnFetch;
    private List<ResponseModel> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mBtnFetch = findViewById(R.id.btnFetch);
        mEtPostId = findViewById(R.id.etPostId);

        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int postId = Integer.parseInt(mEtPostId.getText().toString());
        apiService.getPosts(postId).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                modelArrayList = response.body();
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
        PostAdapter postAdapter = new PostAdapter(modelArrayList);
        recyclerView.setAdapter(postAdapter);
    }

}