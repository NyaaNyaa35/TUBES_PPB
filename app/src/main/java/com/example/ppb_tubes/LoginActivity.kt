package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var username: EditText
    private lateinit var tag: EditText
    private lateinit var password: EditText

    val hardcoded_person: Person = Person("Test","AJG","test@email.com","123")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.button_login)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login -> {

                username = findViewById(R.id.et_name)
                tag = findViewById(R.id.et_riottag)
                password = findViewById(R.id.et_password)

                val username_text = username.text.toString().trim()
                val tag_text = tag.text.toString().trim()
                val password_text = password.text.toString().trim()

                if (username_text == hardcoded_person.username &&
                    tag_text == hardcoded_person.tag &&
                    password_text == hardcoded_person.password
                ) {
                    val moveIntent = Intent(this@LoginActivity, HomeScreen::class.java)
                    moveIntent.putExtra(HomeScreen.EXTRA_PERSON, hardcoded_person)
                    startActivity(moveIntent)
                } else {
                    val alertDialogBuilder = AlertDialog.Builder(this)
                    alertDialogBuilder.setMessage("Wrong Account entry.\nPlease Try Again").show()
                }
            }
        }
    }
}