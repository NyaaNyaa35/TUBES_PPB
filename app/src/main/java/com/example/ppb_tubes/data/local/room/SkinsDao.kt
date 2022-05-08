package com.example.ppb_tubes.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ppb_tubes.data.local.entity.SkinsEntity

@Dao
interface SkinsDao {
    @Query("SELECT * FROM skins ORDER BY displayName ASC")
    fun getSkins(): LiveData<List<SkinsEntity>>

    @Query("SELECT * FROM skins where bookmarked = 1")
    fun getBookmarkedSkins(): LiveData<List<SkinsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSkins(news: List<SkinsEntity>)

    @Update
    fun updateSkins(skins: SkinsEntity)

    @Query("DELETE FROM skins WHERE bookmarked = 0")
    fun deleteAll()

    @Query("SELECT EXISTS(SELECT * FROM skins WHERE displayName = :title AND bookmarked = 1)")
    fun isSkinsBookmarked(title: String): Boolean
}