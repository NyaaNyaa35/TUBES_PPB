package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.ppb_tubes.WeaponView.*

class Weapon : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon)

         val btnKnife: ImageButton = findViewById(R.id.button_knife)
         btnKnife.setOnClickListener(this)

         val btnClassic: ImageButton = findViewById(R.id.button_Classic)
         btnClassic.setOnClickListener(this)
        /**  val btnFrenzy: ImageButton = findViewById(R.id.button_Frenzy)
         btnFrenzy.setOnClickListener(this)
         val btnGhost: ImageButton = findViewById(R.id.button_Ghost)
         btnGhost.setOnClickListener(this)
         val btnGoldenGun: ImageButton = findViewById(R.id.button_GoldenGun)
         btnGoldenGun.setOnClickListener(this)
         val btnSheriff: ImageButton = findViewById(R.id.button_Sheriff)
         btnSheriff.setOnClickListener(this)
         val btnShorty: ImageButton = findViewById(R.id.button_Shorty)
         btnShorty.setOnClickListener(this)*/

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_knife -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }

            R.id.button_Classic -> {
                val knifeIntent = Intent(this@Weapon, Classic::class.java)
                startActivity(knifeIntent)
            }
            /**R.id.button_Frenzy -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Ghost -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_GoldenGun -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Sheriff -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Shorty -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Stinger-> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Spectre -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Bucky -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Judge -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Bulldog -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Guardian -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Phantom -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Vandal -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Marshal -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Operator-> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Ares-> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_Odin-> {val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)}*/
        }
    }
}