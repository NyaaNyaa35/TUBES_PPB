package com.example.ppb_tubes.WeaponView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppb_tubes.R

class Ghost : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "1baa85b4-4c70-1284-64bb-6481dfc3bb4e"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ghost)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@Ghost,
//                    SkinActivity::class.java
//                )
//                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}