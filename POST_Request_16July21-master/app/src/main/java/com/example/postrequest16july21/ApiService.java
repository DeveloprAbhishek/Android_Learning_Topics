package com.example.postrequest16july21;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    /*
   {postId} means that this value has to be passed by the user and the value passed by the user is consumed
   by @Path("postId")
    */
    @GET("posts")
    Call<ResponseModel> getPost();

    @POST("posts")
    Call<ResponseModel> postData(@Body RequestModel requestModel);
}
