package com.example.getlistofalbums15july21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/albums")
    Call<List<ResponseModel>> getPosts();
}
