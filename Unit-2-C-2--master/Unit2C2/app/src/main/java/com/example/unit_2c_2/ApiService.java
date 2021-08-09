package com.example.unit_2c_2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/us/daily.json")
    Call<List<ResponseModel>> getPosts();
}
