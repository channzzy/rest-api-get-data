package com.example.restapi.api

import com.example.restapi.ResponeMolty
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getMolty() : Call<ResponeMolty>
}