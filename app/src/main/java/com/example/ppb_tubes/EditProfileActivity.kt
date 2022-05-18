package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class EditProfileActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        var EXTRA_PERSON="extra_person"
        var EXTRA_UID="extra_uid"
        private const val TAG = "EditProfileActivity"
    }
    private lateinit var usernameEdt: EditText
    private lateinit var tagEdt: EditText
    private lateinit var conPass: EditText
    private lateinit var fstore: FirebaseFirestore
    private lateinit var storageref: StorageReference
    private lateinit var profileImg: CircleImageView
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val btnEditChange : Button = findViewById(R.id.change_btn)
        userId = intent.getStringExtra(EXTRA_UID).toString()
        fstore = FirebaseFirestore.getInstance()
        storageref = FirebaseStorage.getInstance().getReference()
        profileImg = findViewById(R.id.profile_pict)

        var fileref: StorageReference = storageref.child("users/"+userId+"/profile.jpg")

        fileref.downloadUrl.addOnSuccessListener { Uri ->
            Picasso.get().load(Uri).into(profileImg)
        }
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
                var documentReference: DocumentReference = fstore.collection("users").document(userId)
                if (conPasstext == person.password) {
                    documentReference.update(
                        "username",usernameText,
                        "tag",tagTeks
                    ).addOnCompleteListener(this) {
                        if (it.isSuccessful){
                            Log.d(TAG, "User data updated.")
                        }
                        Log.w(TAG, "Failed to update user data.")
                    }
                    val moveIntent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
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
                val moveIntent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
            .setNegativeButton("No", null)
            .show()
    }
}