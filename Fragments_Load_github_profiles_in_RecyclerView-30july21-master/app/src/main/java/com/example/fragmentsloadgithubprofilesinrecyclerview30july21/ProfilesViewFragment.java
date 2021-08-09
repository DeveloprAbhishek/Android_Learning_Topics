package com.example.fragmentsloadgithubprofilesinrecyclerview30july21;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilesViewFragment extends Fragment {
    private EditText mEtGithubId;
    private Button mBtnCallApi;
    private RecyclerView recyclerView;
    private List<ResponseModel> list;
    private ProfileAdapter profileAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profiles_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mEtGithubId = view.findViewById(R.id.etGithubId);
        recyclerView = view.findViewById(R.id.recyclerView);
        mBtnCallApi = view.findViewById(R.id.btnCallApi);
        list = new ArrayList<>();

        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        String profile = mEtGithubId.getText().toString();
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getProfiles(profile).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if(response.body() != null) {
                    list = response.body();
                    setAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        profileAdapter = new ProfileAdapter(list);
        recyclerView.setAdapter(profileAdapter);
    }
}