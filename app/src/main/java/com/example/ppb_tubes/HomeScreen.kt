package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeScreen : AppCompatActivity() , View.OnClickListener {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        /**val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)!!

         val tvObject: TextView = findViewById(R.id.tv_object_received)
         val text = "Name : ${person.username.toString()},\n" +
        "Riottag : ${person.tag.toString()}, \nEmail : ${person.email.toString()}"
        tvObject.text = text

         */

        val btnWeapon: Button = findViewById(R.id.weapon_ui_button)
        btnWeapon.setOnClickListener(this)

        val btnAgent: Button = findViewById(R.id.agent_ui_button)
        btnAgent.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.weapon_ui_button -> {
                val weaponIntent = Intent(this@HomeScreen, Weapon::class.java)
                startActivity(weaponIntent)
            }
            R.id.agent_ui_button -> {
                val agentIntent = Intent(this@HomeScreen, Agent::class.java)
                startActivity(agentIntent)
            }
        }
    }
}