package com.example.ppb_tubes.Model

data class Weapons(
    val data: Data
) {
    data class Data(
        val uuid: String,
        val displayName: String,
        val displayIcon: String,
        val skins: ArrayList<Skins>
)}

