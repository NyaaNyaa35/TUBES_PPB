package com.example.ppb_tubes.data.remote.retrofit

//import com.example.ppb_tubes.data.remote.response.SkinsByUuidResponse
import com.example.ppb_tubes.data.remote.response.SkinsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("skins")

    fun getSkins(): Call<SkinsResponse>

//    @GET("{weaponUuid}")
//    fun getSkinsByUuid(
//        @Path("weaponUuid") weaponUuid : String
//    ): Call<SkinsByUuidResponse>
}