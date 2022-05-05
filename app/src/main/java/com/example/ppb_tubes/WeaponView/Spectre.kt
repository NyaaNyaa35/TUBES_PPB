package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ppb_tubes.R
import com.example.ppb_tubes.ui.SkinActivity

class Spectre : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "462080d1-4035-2937-7c09-27aa2a5c27a7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spectre)

        val seeSkin: Button = findViewById(R.id.see_skin)
        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.see_skin -> {
                val skinIntent = Intent(
                    this@Spectre,
                    SkinActivity::class.java
                )
                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
                startActivity(skinIntent)
            }
        }
    }
}