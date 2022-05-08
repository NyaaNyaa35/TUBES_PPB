package com.example.ppb_tubes.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ppb_tubes.data.local.entity.SkinsEntity

@Database(entities = [SkinsEntity::class], version = 1, exportSchema = false)
abstract class SkinsDatabase : RoomDatabase() {
    abstract fun skinsDao(): SkinsDao

    companion object {
        @Volatile
        private var instance: SkinsDatabase? = null
        fun getInstance(context: Context): SkinsDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    SkinsDatabase::class.java, "Skins.db"
                ).build()
            }
    }
}