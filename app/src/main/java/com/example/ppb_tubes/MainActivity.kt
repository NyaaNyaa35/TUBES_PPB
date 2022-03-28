package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin: Button = findViewById(R.id.button_login_main)
        btnLogin.setOnClickListener(this)

        //val btnRegister: Button = findViewById(R.id.button_register_main)
        //btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login_main -> {
                val loginIntent = Intent(this@MainActivity, MainActivityWithNav::class.java)
                startActivity(loginIntent)
            }
            //R.id.button_register_main -> {
            //    val registerIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            //    startActivity(registerIntent)
            //}
        }
    }
}