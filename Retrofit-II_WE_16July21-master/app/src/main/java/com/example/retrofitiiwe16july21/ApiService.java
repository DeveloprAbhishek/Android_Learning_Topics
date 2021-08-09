package com.example.retrofitiiwe16july21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/comments")
    Call<List<ResponseModel>> getPosts(@Query("postId") int postId);
}
