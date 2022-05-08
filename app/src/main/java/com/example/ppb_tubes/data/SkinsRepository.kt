package com.example.ppb_tubes.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.ppb_tubes.data.local.entity.SkinsEntity
import com.example.ppb_tubes.data.local.room.SkinsDao
import com.example.ppb_tubes.data.remote.response.SkinsResponse
import com.example.ppb_tubes.data.remote.retrofit.ApiServices
import com.example.ppb_tubes.utils.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class SkinsRepository private constructor(
    private val apiService: ApiServices,
    private val skinsDao: SkinsDao,
    private val appExecutors: AppExecutors
) {

    private val result = MediatorLiveData<Result<List<SkinsEntity>>>()

    fun getHeadlineSkins(): LiveData<Result<List<SkinsEntity>>> {
        result.value = Result.Loading
        val client = apiService.getSkins()
        client.enqueue(object : Callback<SkinsResponse> {
            override fun onResponse(call: Call<SkinsResponse>, response: Response<SkinsResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()!!.data
                    val skinsList = ArrayList<SkinsEntity>()
                    appExecutors.diskIO.execute {
                        data.forEach { skin_article ->
                            val isBookmarked = skinsDao.isSkinsBookmarked(skin_article.weaponDisplayName)
                            if (skin_article.weaponDisplayIcon.isNullOrEmpty() == false && skin_article.weaponDisplayName.contains("Standard") == false){
                                val skin = SkinsEntity(
                                    skin_article.uuid,
                                    skin_article.weaponDisplayName,
                                    skin_article.weaponDisplayIcon,
                                    isBookmarked
                                )
                                skinsList.add(skin)
                            }
                        }
                        skinsDao.deleteAll()
                        skinsDao.insertSkins(skinsList)
                    }
                }
            }

            override fun onFailure(call: Call<SkinsResponse>, t: Throwable) {
                result.value = Result.Error(t.message.toString())
            }
        })
        val localData = skinsDao.getSkins()
        result.addSource(localData) { newData: List<SkinsEntity> ->
            result.value = Result.Success(newData)
        }
        return result
    }

    fun getBookmarkedSkins(): LiveData<List<SkinsEntity>> {
        return skinsDao.getBookmarkedSkins()
    }

    fun setBookmarkedSkins(skins: SkinsEntity, bookmarkState: Boolean) {
        appExecutors.diskIO.execute {
            skins.isBookmarked = bookmarkState
            skinsDao.updateSkins(skins)
        }
    }

    companion object {

        @Volatile
        private var instance: SkinsRepository? = null
        fun getInstance(
            apiService: ApiServices,
            skinsDao: SkinsDao,
            appExecutors: AppExecutors
        ): SkinsRepository =
            instance ?: synchronized(this) {
                instance ?: SkinsRepository(apiService, skinsDao, appExecutors)
            }.also { instance = it }
    }
}