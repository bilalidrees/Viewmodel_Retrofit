package com.example.ahmedrazaidrees.viewmodel_retrofit

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


interface Api {

    var BASE_URL: String


    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>

}