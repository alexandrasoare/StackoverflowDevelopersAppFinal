package com.example.adasoare.stackoverflowdevelopersapp.rest;

import com.example.adasoare.stackoverflowdevelopersapp.model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserAPIService {
    @GET("/2.2/users?order=desc&site=stackoverflow")
    Call<UserList> getUsers(@Query("sort") String sortBy);
}
