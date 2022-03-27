package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.ppb_tubes.WeaponView.*

class Weapon : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon)

        val btnKnife: ImageButton = findViewById(R.id.button_knife)
        btnKnife.setOnClickListener(this)

        val btnClassic: ImageButton = findViewById(R.id.button_Classic)
        btnClassic.setOnClickListener(this)

        val btnFrenzy: ImageButton = findViewById(R.id.button_Frenzy)
        btnFrenzy.setOnClickListener(this)

        val btnGhost: ImageButton = findViewById(R.id.button_Ghost)
        btnGhost.setOnClickListener(this)

        val btnGoldenGun: ImageButton = findViewById(R.id.button_GoldenGun)
        btnGoldenGun.setOnClickListener(this)

        val btnSheriff: ImageButton = findViewById(R.id.button_Sheriff)
        btnSheriff.setOnClickListener(this)

        val btnShorty: ImageButton = findViewById(R.id.button_Shorty)
        btnShorty.setOnClickListener(this)

        val btnStinger: ImageButton = findViewById(R.id.button_Stinger)
        btnStinger.setOnClickListener(this)

        val btnSpectre: ImageButton = findViewById(R.id.button_Spectre)
        btnSpectre.setOnClickListener(this)

        val btnBucky: ImageButton = findViewById(R.id.button_Bucky)
        btnBucky.setOnClickListener(this)

        val btnJudge: ImageButton = findViewById(R.id.button_Judge)
        btnJudge.setOnClickListener(this)

        val btnMarshal: ImageButton = findViewById(R.id.button_Marshal)
        btnMarshal.setOnClickListener(this)

        val btnOperator: ImageButton = findViewById(R.id.button_Operator)
        btnOperator.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_knife -> {
                val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
                startActivity(knifeIntent)
            }

            R.id.button_Classic -> {
                val classicIntent = Intent(this@Weapon, Classic::class.java)
                startActivity(classicIntent)
            }
            R.id.button_Frenzy -> {
                val frenzyIntent = Intent(this@Weapon, Frenzy::class.java)
                startActivity(frenzyIntent)
            }
            R.id.button_Ghost -> {
                val ghostIntent = Intent(this@Weapon, Ghost::class.java)
                startActivity(ghostIntent)
            }
            R.id.button_GoldenGun -> {
                val ggunIntent = Intent(this@Weapon, GoldenGun::class.java)
                startActivity(ggunIntent)
            }
            R.id.button_Sheriff -> {
                val sheriffIntent = Intent(this@Weapon, Sheriff::class.java)
                startActivity(sheriffIntent)
            }
            R.id.button_Shorty -> {
                val shortyIntent = Intent(this@Weapon, Shorty::class.java)
                startActivity(shortyIntent)
            }
            R.id.button_Stinger -> {
                val stingerIntent = Intent(this@Weapon, Stinger::class.java)
                startActivity(stingerIntent)
            }
            R.id.button_Spectre -> {
                val spectreIntent = Intent(this@Weapon, Spectre::class.java)
                startActivity(spectreIntent)
            }
            R.id.button_Bucky -> {
                val buckyIntent = Intent(this@Weapon, Bucky::class.java)
                startActivity(buckyIntent)
            }
            R.id.button_Judge -> {
                val judgeIntent = Intent(this@Weapon, Judge::class.java)
                startActivity(judgeIntent)
            }
            R.id.button_Marshal -> {
                val marshalIntent = Intent(this@Weapon, Marshall::class.java)
                startActivity(marshalIntent)
            }
            R.id.button_Operator -> {
                val operatorIntent = Intent(this@Weapon, Operator::class.java)
                startActivity(operatorIntent)
            }
            /**
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

            R.id.button_Ares-> {
            val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
            startActivity(knifeIntent)
            }
            R.id.button_Odin-> {val knifeIntent = Intent(this@Weapon, TacticalKnife::class.java)
            startActivity(knifeIntent)}*/
        }
    }
}