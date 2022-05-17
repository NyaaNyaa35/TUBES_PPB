package com.example.ppb_tubes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ppb_tubes.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.HashMap


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var username: EditText
    private lateinit var tag: EditText
    private lateinit var password: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore

    companion object {
        const val EXTRA_UID = "extra_uid"
        private const val TAG = "LoginActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fstore = FirebaseFirestore.getInstance()
        auth = Firebase.auth

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


                val userID = auth.currentUser!!.uid

                var documentReference: DocumentReference = fstore.collection("users").document(userID)
                var user : HashMap<String, String> = HashMap<String, String> ()
                user.put("username", username_text)
                user.put("tag",tag_text)
                user.put("password",password_text)
                documentReference.set(user).addOnCompleteListener(this){
                        if (it.isSuccessful){
                            Log.d(TAG, "User added to database.")
                        }
                        Log.w(TAG, "Failed to add user to database")
                    }

                val moveIntent = Intent(this@LoginActivity, HomeScreen::class.java)
                startActivity(moveIntent)
                finish()
            }
        }
    }
}