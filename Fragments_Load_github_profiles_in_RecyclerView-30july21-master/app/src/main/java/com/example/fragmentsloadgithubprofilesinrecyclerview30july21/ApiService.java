package com.example.fragmentsloadgithubprofilesinrecyclerview30july21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/users/{user}/repos")
    Call<List<ResponseModel>> getProfiles(@Path("user") String user);
}
