package com.example.adasoare.stackoverflowdevelopersapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static  final  String STACKOVERFLOW_BASE_URL="https://api.stackexchange.com";
    public static Retrofit retrofit = null;

    public static  Retrofit getStackOverFLowClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(STACKOVERFLOW_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
