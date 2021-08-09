package com.example.getresourcesapi15july21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private ProgressBar progressBar;
    private RelativeLayout relativeLayout;
    private TextView mTvName, mTvYear, mTvPantone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        int postId = getIntent().getIntExtra("num", -1);
        Toast.makeText(this, ""+postId, Toast.LENGTH_SHORT).show();
        callApi(postId);

    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBar);
        relativeLayout = findViewById(R.id.relativeLayout);
        mTvName = findViewById(R.id.tvName);
        mTvYear = findViewById(R.id.tvYear);
        mTvPantone = findViewById(R.id.tvPantoneValue);
    }

    private void callApi(int postId) {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getPost(postId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                mTvName.setText(model.getData().getName());
                mTvYear.setText(model.getData().getYear() + "");
                mTvPantone.setText(model.getData().getPantoneValue());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

}