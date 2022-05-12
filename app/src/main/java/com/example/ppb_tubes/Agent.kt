package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.example.ppb_tubes.AgentView.*
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView

class Agent : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent)

        val sideNav: ImageView = findViewById(R.id.side_nav)
        sideNav.setOnClickListener(this)

        val btnAstra: ImageButton = findViewById(R.id.button_astra)
        btnAstra.setOnClickListener(this)

        val btnBreach: ImageButton = findViewById(R.id.button_breach)
        btnBreach.setOnClickListener(this)

        val btnBrimstone: ImageButton = findViewById(R.id.button_brimstone)
        btnBrimstone.setOnClickListener(this)

        val btnChamber: ImageButton = findViewById(R.id.button_chamber)
        btnChamber.setOnClickListener(this)

        val btnCypher: ImageButton = findViewById(R.id.button_cypher)
        btnCypher.setOnClickListener(this)

        val btnFade: ImageButton = findViewById(R.id.button_fade)
        btnFade.setOnClickListener(this)

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

        val btnSage: ImageButton = findViewById(R.id.button_sage)
        btnSage.setOnClickListener(this)

        val btnSkye: ImageButton = findViewById(R.id.button_skye)
        btnSkye.setOnClickListener(this)

        val btnSova: ImageButton = findViewById(R.id.button_sova)
        btnSova.setOnClickListener(this)

        val btnViper: ImageButton = findViewById(R.id.button_viper)
        btnViper.setOnClickListener(this)

        val btnYoru: ImageButton = findViewById(R.id.button_yoru)
        btnYoru.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.side_nav -> {
                val mFragmentManager = supportFragmentManager
                val mSideNavFragment = SideNavFragment()

                val rootView: ViewGroup = findViewById(R.id.agent_layout)
                val mFade: androidx.transition.Fade =
                    androidx.transition.Fade(androidx.transition.Fade.IN)
                TransitionManager.beginDelayedTransition(rootView, mFade)

                mFragmentManager
                    .beginTransaction()
                    .add(R.id.agent_layout, mSideNavFragment,
                        SideNavFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.button_astra -> {
                val knifeIntent = Intent(this@Agent, Astra::class.java)
                startActivity(knifeIntent)
            }
            R.id.button_breach -> {
                val breachIntent = Intent(this@Agent, Breach::class.java)
                startActivity(breachIntent)
            }
            R.id.button_brimstone -> {
                val brimstoneIntent = Intent(this@Agent, Brimstone::class.java)
                startActivity(brimstoneIntent)
            }
            R.id.button_chamber -> {
                val chamberIntent = Intent(this@Agent, Chamber::class.java)
                startActivity(chamberIntent)
            }
            R.id.button_cypher -> {
                val cypherIntent = Intent(this@Agent, Cypher::class.java)
                startActivity(cypherIntent)
            }
            R.id.button_fade -> {
                val fadeIntent = Intent(this@Agent, Fade::class.java)
                startActivity(fadeIntent)
            }
            R.id.button_jett -> {
                val jettIntent = Intent(this@Agent, Jett::class.java)
                startActivity(jettIntent)
            }
            R.id.button_kayo -> {
                val kayoIntent = Intent(this@Agent, Kayo::class.java)
                startActivity(kayoIntent)
            }
            R.id.button_killjoy -> {
                val killjoyIntent = Intent(this@Agent, Killjoy::class.java)
                startActivity(killjoyIntent)
            }
            R.id.button_neon -> {
                val neonIntent = Intent(this@Agent, Neon::class.java)
                startActivity(neonIntent)
            }
            R.id.button_omen -> {
                val omenIntent = Intent(this@Agent, Omen::class.java)
                startActivity(omenIntent)
            }
            R.id.button_phoenix -> {
                val phoenixIntent = Intent(this@Agent, Phoenix::class.java)
                startActivity(phoenixIntent)
            }
            R.id.button_raze -> {
                val razeIntent = Intent(this@Agent, Raze::class.java)
                startActivity(razeIntent)
            }
            R.id.button_reyna -> {
                val reynaIntent = Intent(this@Agent, Reyna::class.java)
                startActivity(reynaIntent)
            }
            R.id.button_sage -> {
                val sageIntent = Intent(this@Agent, Sage::class.java)
                startActivity(sageIntent)
            }
            R.id.button_skye -> {
                val skyeIntent = Intent(this@Agent, Skye::class.java)
                startActivity(skyeIntent)
            }
            R.id.button_sova -> {
                val sovaIntent = Intent(this@Agent, Sova::class.java)
                startActivity(sovaIntent)
            }
            R.id.button_viper -> {
                val viperIntent = Intent(this@Agent, Viper::class.java)
                startActivity(viperIntent)
            }
            R.id.button_yoru -> {
                val yoruIntent = Intent(this@Agent, Yoru::class.java)
                startActivity(yoruIntent)
            }
        }
    }
}