package com.example.ppb_tubes.WeaponView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppb_tubes.R

class Stinger : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "f7e1b454-4ad4-1063-ec0a-159e56b58941"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stinger)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@Stinger,
//                    SkinActivity::class.java
//                )
//                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}