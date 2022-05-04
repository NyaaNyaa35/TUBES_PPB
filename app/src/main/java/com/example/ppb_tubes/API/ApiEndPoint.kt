package com.example.ppb_tubes.API

import com.example.ppb_tubes.Model.Skins
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("skins")

    fun getSkins(): Call<Skins>
}