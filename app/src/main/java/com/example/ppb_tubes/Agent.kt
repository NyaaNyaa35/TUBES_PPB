package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.ppb_tubes.AgentView.*

class Agent : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)

        val btnAstra: ImageButton = findViewById(R.id.button_astra)
        btnAstra.setOnClickListener(this)

        val btnBreach: ImageButton = findViewById(R.id.button_breach)
        btnBreach.setOnClickListener(this)

        /**
        val btnBrimstone: ImageButton = findViewById(R.id.button_brimstone)
        btnBrimstone.setOnClickListener(this)

        val btnChamber: ImageButton = findViewById(R.id.button_chamber)
        btnChamber.setOnClickListener(this)

        val btnCypher: ImageButton = findViewById(R.id.button_cypher)
        btnCypher.setOnClickListener(this)

        val btnJett: ImageButton = findViewById(R.id.button_jett)
        btnJett.setOnClickListener(this)

        val btnKayo: ImageButton = findViewById(R.id.button_kayo)
        btnKayo.setOnClickListener(this)

        val btnKilljoy: ImageButton = findViewById(R.id.button_killjoy)
        btnKilljoy.setOnClickListener(this)

        val btnNeon: ImageButton = findViewById(R.id.button_neon)
        btnNeon.setOnClickListener(this)

        val btnOmen: ImageButton = findViewById(R.id.button_omen)
        btnOmen.setOnClickListener(this)

        val btnPhoenix: ImageButton = findViewById(R.id.button_phoenix)
        btnPhoenix.setOnClickListener(this)

        val btnRaze: ImageButton = findViewById(R.id.button_raze)
        btnRaze.setOnClickListener(this)

        val btnReyna: ImageButton = findViewById(R.id.button_reyna)
        btnReyna.setOnClickListener(this)

        val btnSkye: ImageButton = findViewById(R.id.button_skye)
        btnSkye.setOnClickListener(this)

        val btnSova: ImageButton = findViewById(R.id.button_sova)
        btnSova.setOnClickListener(this)

        val btnViper: ImageButton = findViewById(R.id.button_viper)
        btnViper.setOnClickListener(this)

        val btnYoru: ImageButton = findViewById(R.id.button_yoru)
        btnYoru.setOnClickListener(this)*/
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_astra -> {
                val knifeIntent = Intent(this@Agent, Astra::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_breach -> {
                val breachIntent = Intent(this@Agent, Breach::class.java)
                startActivity(breachIntent)
            }
            /**
            R.id.button_Frenzy -> {
                val frenzyIntent = Intent(this@Agent, Frenzy::class.java)
                startActivity(frenzyIntent)
            }
            R.id.button_Ghost -> {
                val ghostIntent = Intent(this@Agent, Ghost::class.java)
                startActivity(ghostIntent)
            }
            R.id.button_GoldenGun -> {
                val ggunIntent = Intent(this@Agent, GoldenGun::class.java)
                startActivity(ggunIntent)
            }
            R.id.button_Sheriff -> {
                val sheriffIntent = Intent(this@Agent, Sheriff::class.java)
                startActivity(sheriffIntent)
            }
            R.id.button_Shorty -> {
                val shortyIntent = Intent(this@Agent, Shorty::class.java)
                startActivity(shortyIntent)
            }
            R.id.button_Stinger -> {
                val stingerIntent = Intent(this@Agent, Stinger::class.java)
                startActivity(stingerIntent)
            }
            R.id.button_Spectre -> {
                val spectreIntent = Intent(this@Agent, Spectre::class.java)
                startActivity(spectreIntent)
            }
            R.id.button_Bucky -> {
                val buckyIntent = Intent(this@Agent, Bucky::class.java)
                startActivity(buckyIntent)
            }
            R.id.button_Judge -> {
                val judgeIntent = Intent(this@Agent, Judge::class.java)
                startActivity(judgeIntent)
            }
            R.id.button_Marshal -> {
                val marshalIntent = Intent(this@Agent, Marshall::class.java)
                startActivity(marshalIntent)
            }
            R.id.button_Operator -> {
                val operatorIntent = Intent(this@Agent, Operator::class.java)
                startActivity(operatorIntent)
            }
            R.id.button_Ares-> {
                val aresIntent = Intent(this@Agent, Ares::class.java)
                startActivity(aresIntent)
            }
            R.id.button_Odin-> {
                val odinIntent = Intent(this@Agent, Odin::class.java)
                startActivity(odinIntent)
            }
            R.id.button_Bulldog -> {
                val bulldogIntent = Intent(this@Agent, Bulldog::class.java)
                startActivity(bulldogIntent)
            }*/
        }
    }
}