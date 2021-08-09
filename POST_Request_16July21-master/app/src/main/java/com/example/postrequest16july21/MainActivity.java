package com.example.postrequest16july21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText mEtEmail, mEtPassword, mEtTitle, mEtRequestType;
    private Button mBtnPost;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtTitle = findViewById(R.id.etTitle);
        mEtRequestType = findViewById(R.id.etRequestType);
        mBtnPost = findViewById(R.id.btnPost);
        progressBar = findViewById(R.id.progressBar);

        mBtnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                setDataToApi();
            }
        });
    }

    private void setDataToApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        String email = mEtEmail.getText().toString();
        String password = mEtPassword.getText().toString();
        String title = mEtTitle.getText().toString();
        String requestType = mEtRequestType.getText().toString();
        RequestModel requestModel = new RequestModel(email, password, title, requestType);
        apiService.postData(requestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("email", response.body().getEmail());
                intent.putExtra("password", response.body().getPassword());
                intent.putExtra("title", response.body().getTitle());
                intent.putExtra("requestType", response.body().getRequestType());
                startActivity(intent);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}