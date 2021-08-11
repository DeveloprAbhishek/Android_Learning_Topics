package com.example.itunesapi15july21;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search")
    Call<ResponseModel> getTrack(@Query("term") String term);
}
