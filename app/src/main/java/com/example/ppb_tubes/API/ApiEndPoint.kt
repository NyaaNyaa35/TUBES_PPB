package com.example.ppb_tubes.API

import com.example.ppb_tubes.Model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
//
//    @GET("skins")
//
//    fun getSkins(): Call<Skins>

    @GET("{weaponUuid}")

    fun getWeapon(
        @Path("weaponUuid") weaponUuid : String
    ): Call<Weapons>
}