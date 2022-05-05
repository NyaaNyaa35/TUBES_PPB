package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ppb_tubes.R
import com.example.ppb_tubes.ui.SkinActivity

class Vandal : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "9c82e19d-4575-0200-1a81-3eacf00cf872"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vandal)

        val seeSkin: Button = findViewById(R.id.see_skin)
        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.see_skin -> {
                val skinIntent = Intent(
                    this@Vandal,
                    SkinActivity::class.java
                )
                skinIntent.putExtra(SkinActivity.EXTRA_WEAPONUUID, weaponUuid)
                startActivity(skinIntent)
            }
        }
    }
}