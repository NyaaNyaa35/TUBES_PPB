package com.example.ppb_tubes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ppb_tubes.API.ApiService
import com.example.ppb_tubes.Adapter.SkinAdapter
import com.example.ppb_tubes.Model.Skins
import com.example.ppb_tubes.R
import kotlinx.android.synthetic.main.activity_skin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkinActivity : AppCompatActivity() {
    companion object {
        const val WEAPONNAME = "weapon_name"
    }

    lateinit var skinAdapter : SkinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin)
    }

    override fun onStart(){
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView() {
        skinAdapter = SkinAdapter(arrayListOf())
        recyclerView_skin.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = skinAdapter
        }
    }

    private fun getDataFromApi() {
        ApiService.endpoint.getSkins()
            .enqueue(object : Callback<Skins> {
                override fun onResponse(call: Call<Skins>, response: Response<Skins>) {
                    if (response.isSuccessful){
                        showIcon(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<Skins>, t: Throwable) {
                    printLog("onFailure : $t")
                }

            })
    }

    private fun printLog(message: String){
        Log.d(WEAPONNAME, message)
    }

    private fun showIcon(skin: Skins){
        val results = skin.data
        skinAdapter.setData(results, WEAPONNAME)
    }
}