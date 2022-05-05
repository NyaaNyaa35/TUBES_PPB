package com.example.ppb_tubes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ppb_tubes.API.ApiService
import com.example.ppb_tubes.Adapter.SkinAdapter
import com.example.ppb_tubes.Model.Skins
import com.example.ppb_tubes.Model.Weapons
import com.example.ppb_tubes.R
import kotlinx.android.synthetic.main.activity_skin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SkinActivity : AppCompatActivity() {
    companion object {
        val EXTRA_WEAPONUUID : String = "WEAPON_NAME"
    }

    lateinit var skinAdapter : SkinAdapter

    lateinit var skin : ArrayList<Skins>

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
        val uuid = intent.getStringExtra(EXTRA_WEAPONUUID)
        if (uuid != null) {
            ApiService.endpoint.getWeapon(uuid)
                .enqueue(object : Callback<Weapons> {
                    override fun onResponse(call: Call<Weapons>, response: Response<Weapons>) {
                        if (response.isSuccessful){
                            showIcon(response.body()!!)
                        } else {
                            printLog("Response onFailure : ${response.message()}")
                        }
                    }

                    override fun onFailure(call: Call<Weapons>, t: Throwable) {
                        printLog("onFailure API: $t")
                    }
                })
        }
    }

    private fun printLog(message: String){
        Log.d(EXTRA_WEAPONUUID, message)
    }

    private fun showIcon(weapon: Weapons){
        val results = weapon.data
        skin = results.skins
        skinAdapter.setData(skin)
    }
}