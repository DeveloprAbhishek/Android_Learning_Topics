package com.example.inshortsnewsapp16july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView recyclerView;
    private EditText editText;
    private NewsAdapter newsAdapter;
    private List<DataModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.etSearchNews);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s != null && s.length() > 2){
                    callApi(s.toString());
                    Log.d("TAG", s.toString());
                }
            }
        });
    }

    @Override
    public void onClickItem(DataModel model) {
        String url = model.getReadMoreUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    void setAdapter(){
        newsAdapter = new NewsAdapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    void callApi(String s) {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getNews(s).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response != null && response.isSuccessful()) {
                    list = response.body().getData();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}