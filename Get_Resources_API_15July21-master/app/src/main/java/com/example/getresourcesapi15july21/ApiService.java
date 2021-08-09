package com.example.getresourcesapi15july21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/api/unknown/{postId}")
    Call<ResponseModel> getPost(@Path("postId") int postId);
}
