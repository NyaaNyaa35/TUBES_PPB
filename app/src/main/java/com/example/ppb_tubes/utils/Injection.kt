package com.example.ppb_tubes.utils

import android.content.Context
import com.example.ppb_tubes.data.SkinsRepository
import com.example.ppb_tubes.data.local.room.SkinsDatabase
import com.example.ppb_tubes.data.remote.retrofit.ApiConfig

object Injection {

    fun provideRepository(context: Context) : SkinsRepository {
        val apiService = ApiConfig.getApiService()
        val database = SkinsDatabase.getInstance(context)
        val dao = database.skinsDao()
        val appExecutors = AppExecutors()
        return SkinsRepository.getInstance(apiService, dao, appExecutors)
    }
}