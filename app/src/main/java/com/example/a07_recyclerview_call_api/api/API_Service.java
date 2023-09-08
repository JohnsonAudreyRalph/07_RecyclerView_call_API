package com.example.a07_recyclerview_call_api.api;

import com.example.a07_recyclerview_call_api.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API_Service {

    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    API_Service api_service = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(API_Service.class);

    @GET("posts")
    Call<List<User>> gesListUser(@Query("userId") int userId);
}
