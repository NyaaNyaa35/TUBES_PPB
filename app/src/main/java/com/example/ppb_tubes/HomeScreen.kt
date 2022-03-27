package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class HomeScreen : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
//        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
//        val tvObject: TextView = findViewById(R.id.tv_object_received)
//        val text = "Name : ${person.username.toString()}\n" + "Riottag : ${person.tag.toString()} \nEmail : ${person.email.toString()}"
//        tvObject.text = text

        val btnProfile: Button = findViewById(R.id.profile_button)
        btnProfile.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.profile_button -> {
                val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
                val moveIntent = Intent(this@HomeScreen, ProfileActivity::class.java)
                moveIntent.putExtra(ProfileActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
        }
    }
}