package com.example.ppb_tubes.WeaponView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppb_tubes.R

class Odin : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "63e6c2b6-4a8e-869c-3d4c-e38355226584"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_odin)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@Odin,
//                    SkinActivity::class.java
//                )
//                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}