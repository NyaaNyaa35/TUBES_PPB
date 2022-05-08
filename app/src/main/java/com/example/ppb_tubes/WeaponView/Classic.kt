package com.example.ppb_tubes.WeaponView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ppb_tubes.R

class Classic : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "29a0cfab-485b-f5d5-779a-b59f85e204a8"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@Classic,
//                    SkinActivity::class.java
//                )
//                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}