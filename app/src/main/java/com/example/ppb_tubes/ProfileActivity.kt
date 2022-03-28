package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        var EXTRA_PERSON= "extra_person"
    }

    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var password: TextView
    private lateinit var chgPass: TextView
//    val hardcodedPerson: Person = Person("Test","AJG","test@email.com","123")

    override fun onCreate(savedInstanceState: Bundle?) {
        val person = intent.getParcelableExtra<Person>(EditProfileActivity.EXTRA_PERSON) as Person
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        chgPass = findViewById(R.id.change_pass)
        chgPass.setOnClickListener(this)

        username = findViewById(R.id.username)
        username.text = person.username + "#" +person.tag
        email = findViewById(R.id.email)
        email.text = person.email
        val btnEditProfile : Button = findViewById(R.id.edit_btn)
        btnEditProfile.setOnClickListener(this)
        val btnUploadPic : Button = findViewById(R.id.upload_btn)
        btnUploadPic.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.edit_btn -> {
                val person = intent.getParcelableExtra<Person>(EditProfileActivity.EXTRA_PERSON) as Person
                val moveIntent = Intent(this@ProfileActivity, EditProfileActivity::class.java)
                moveIntent.putExtra(EditProfileActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
            R.id.upload_btn -> {

            }
            R.id.change_pass -> {
                val person = intent.getParcelableExtra<Person>(EditProfileActivity.EXTRA_PERSON) as Person
                val moveIntent = Intent(this@ProfileActivity, ChangePassActivity::class.java)
                moveIntent.putExtra(ChangePassActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
        }

    }
}