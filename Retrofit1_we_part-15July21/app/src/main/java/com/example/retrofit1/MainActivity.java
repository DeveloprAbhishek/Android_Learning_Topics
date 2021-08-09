package com.example.retrofit1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button mBtnCallApi;
    private EditText mEtUserId;
    private TextView mTvFirstName, mTvLastName, mTvEmail;
    private ImageView mIvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtUserId = findViewById(R.id.etUserId);
        mTvFirstName = findViewById(R.id.tvfirstName);
        mTvLastName = findViewById(R.id.tvLastName);
        mTvEmail = findViewById(R.id.tvEmail);
        mIvAvatar = findViewById(R.id.ivAvatar);
        mBtnCallApi = findViewById(R.id.btnCallApi);

        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int userId = Integer.parseInt(mEtUserId.getText().toString());
        apiService.getUser(userId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                String firstName = model.getData().getFirstName();
                String lastName = model.getData().getLastName();
                String email = model.getData().getEmail();

                mTvFirstName.setText(firstName);
                mTvLastName.setText(lastName);
                mTvEmail.setText(email);
                Glide.with(mIvAvatar).load(model.getData().getAvatar()).into(mIvAvatar);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}