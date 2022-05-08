
package com.example.ppb_tubes.data.remote.response

import com.google.gson.annotations.SerializedName

data class SkinsResponse (
    @field:SerializedName("data")
    val data : ArrayList<DataSkin>
)

data class DataSkin(
    @field:SerializedName("uuid")
    val uuid : String,

    @field:SerializedName("displayName")
    val weaponDisplayName : String,

    @field:SerializedName("displayIcon")
    val weaponDisplayIcon : String,
)

