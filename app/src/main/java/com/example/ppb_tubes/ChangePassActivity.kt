package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class ChangePassActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        var EXTRA_PERSON= "extra_person"
        var EXTRA_UID="extra_uid"
        private const val TAG = "ChangePassActivity"
    }
    private lateinit var newPass: EditText
    private lateinit var oldPass: EditText
    private lateinit var conPass: EditText
    private lateinit var fstore: FirebaseFirestore
    private lateinit var userId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pass)
        val btnEditChange : Button = findViewById(R.id.change_pass_btn)
        userId = intent.getStringExtra(EXTRA_UID).toString()
        fstore = FirebaseFirestore.getInstance()
        btnEditChange.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.change_pass_btn -> {

                val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person

                newPass = findViewById(R.id.new_pass)
                oldPass = findViewById(R.id.old_pass)
                conPass = findViewById(R.id.confirm_pass)

                val newPassText = newPass.text.toString().trim()
                val oldPassText = oldPass.text.toString().trim()
                val conPassText = conPass.text.toString().trim()

                if (newPassText == "" || oldPassText == "" || conPassText == "") {
                    val alertDialogBuilder = AlertDialog.Builder(this)
                    alertDialogBuilder.setMessage("Please Complete The Form").show()
                } else {
                    if (oldPassText == person.password && conPassText == person.password) {
                        var documentReference: DocumentReference = fstore.collection("users").document(userId)
                        documentReference.update(
                            "password",newPassText
                        ).addOnCompleteListener(this) {
                            if (it.isSuccessful){
                                Log.d(TAG, "User password updated.")
                            }
                            Log.w(TAG, "Failed to update user password.")
                        }
                        val moveIntent = Intent(this@ChangePassActivity, ProfileActivity::class.java)
                        startActivity(moveIntent)
                        finish()
                    } else {
                        val alertDialogBuilder = AlertDialog.Builder(this)
                        alertDialogBuilder.setMessage("Wrong Password entry.\nPLease Try Again").show()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Warning")
            .setMessage("Please Confirm Changes to Go Back")
            .setPositiveButton("Yes", null)
            .show()
    }
}