package com.example.ppb_tubes.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skins")
class SkinsEntity (

    @field:ColumnInfo(name = "uuid")
    @field:PrimaryKey
    val uuid: String,

    @field:ColumnInfo(name = "displayName")
    val displayname: String,

    @field:ColumnInfo(name = "displayIcon")
    val urlToImage: String,

    @field:ColumnInfo(name = "bookmarked")
    var isBookmarked: Boolean
    )
