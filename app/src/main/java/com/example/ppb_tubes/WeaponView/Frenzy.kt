package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ppb_tubes.R
import com.example.ppb_tubes.ui.SkinActivity

class Frenzy : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "44d4e95c-4157-0037-81b2-17841bf2e8e3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frenzy)

        val seeSkin: Button = findViewById(R.id.see_skin)
        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.see_skin -> {
                val skinIntent = Intent(
                    this@Frenzy,
                    SkinActivity::class.java
                )
                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
                startActivity(skinIntent)
            }
        }
    }
}