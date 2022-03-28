package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class EditProfileActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        var EXTRA_PERSON="extra_person"
//        const val EXTRA_PASSWORD= "extra_password"
//        const val EXTRA_EMAIL="extra_email"
    }
    private lateinit var usernameEdt: EditText
    private lateinit var tagEdt: EditText
    private lateinit var conPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val btnEditChange : Button = findViewById(R.id.change_btn)
        btnEditChange.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.change_btn -> {
                val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
                usernameEdt = findViewById(R.id.edt_username)
                tagEdt = findViewById(R.id.edt_tag)
                conPass = findViewById(R.id.confirm_pass)

                var usernameText = usernameEdt.text.toString().trim()
                var tagTeks = tagEdt.text.toString().trim()
                val conPasstext = conPass.text.toString().trim()

                if (usernameText == "" || tagTeks == "") {
                    usernameText = person.username.toString().trim()
                    tagTeks = person.tag.toString().trim()
                }
                if (conPasstext == person.password) {
                    val personEdt = Person(usernameText,tagTeks,person.email,person.password)
                    val moveIntent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
                    moveIntent.putExtra(ProfileActivity.EXTRA_PERSON, personEdt)
                    startActivity(moveIntent)
                    finish()
                } else {
                    val alertDialogBuilder = AlertDialog.Builder(this)
                    alertDialogBuilder.setMessage("Wrong Password entry.\nPLease Try Again").show()
                }
            }
        }
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Closing Activity")
            .setMessage("Are you sure you want to close this activity? \nData will not be saved")
            .setPositiveButton("Yes") {
                    dialog, which -> finish()
                val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
                val moveIntent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
                moveIntent.putExtra(ProfileActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
            .setNegativeButton("No", null)
            .show()
    }
}