package com.example.ppb_tubes.Model

data class Skins(
    val data: ArrayList<Data>
) {
    data class Data(
        val uuid: String,
        val displayName: String,
        val displayIcon: String
    )
}
