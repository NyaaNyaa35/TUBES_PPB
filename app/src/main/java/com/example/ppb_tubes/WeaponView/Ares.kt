package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.ppb_tubes.R
import com.example.ppb_tubes.ui.SkinActivity

class Ares : AppCompatActivity(), View.OnClickListener {

    private val weaponName : String = "Ares"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ares)

        val seeSkin: Button = findViewById(R.id.see_skin)
        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.see_skin -> {
                val skinIntent = Intent(this@Ares,
                    SkinActivity::class.java)
                skinIntent.putExtra(SkinActivity.WEAPONNAME,weaponName)
                startActivity(skinIntent)
            }
        }
    }

}