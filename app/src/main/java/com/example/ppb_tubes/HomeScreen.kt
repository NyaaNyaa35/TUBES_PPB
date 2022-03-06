package com.example.ppb_tubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeScreen : AppCompatActivity() {
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

    }
}