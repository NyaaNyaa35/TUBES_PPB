package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ppb_tubes.R
import com.example.ppb_tubes.ui.SkinActivity

class Sheriff : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "e336c6b8-418d-9340-d77f-7a9e4cfe0702"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sheriff)

        val seeSkin: Button = findViewById(R.id.see_skin)
        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.see_skin -> {
                val skinIntent = Intent(
                    this@Sheriff,
                    SkinActivity::class.java
                )
                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
                startActivity(skinIntent)
            }
        }
    }
}