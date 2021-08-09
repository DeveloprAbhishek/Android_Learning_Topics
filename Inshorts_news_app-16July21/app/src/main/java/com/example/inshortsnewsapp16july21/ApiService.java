package com.example.inshortsnewsapp16july21;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("news")
    Call<ResponseModel> getNews(@Query("category") String category);

}
