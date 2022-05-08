package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.NonNull
import com.example.ppb_tubes.ui.Thread.CreateThreadActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInApi
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.example.ppb_tubes.ui.skins.allskins.SkinActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class HomeScreen : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_UID = "extra_uid"
        const val EXTRA_PERSON = "extra_person"
        const val TAG = "Home Screen"
    }
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

// ...
// Initialize Firebase Auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
//        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
//        val tvObject: TextView = findViewById(R.id.tv_object_received)
//        val text = "Name : ${person.username.toString()}\n" + "Riottag : ${person.tag.toString()} \nEmail : ${person.email.toString()}"
//        tvObject.text = text
        auth = Firebase.auth
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        val btnProfile: Button = findViewById(R.id.profile_button)
        btnProfile.setOnClickListener(this)

        val btnThread: Button = findViewById(R.id.thread_ui_button)
        btnThread.setOnClickListener(this)

        val btnWeapon: Button = findViewById(R.id.weapon_ui_button)
        btnWeapon.setOnClickListener(this)

        val btnAgent: Button = findViewById(R.id.agent_ui_button)
        btnAgent.setOnClickListener(this)

        val btnSkins: Button = findViewById(R.id.skins_ui_button)
        btnSkins.setOnClickListener(this)

        val btnLogout: Button = findViewById(R.id.logoutBtn)
        btnLogout.setOnClickListener(this)
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
            R.id.thread_ui_button -> {
                val threadIntent = Intent(this,CreateThreadActivity::class.java)
                startActivity(threadIntent)
            }
            R.id.profile_button -> {
                //val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
                val moveIntent = Intent(this@HomeScreen, ProfileActivity::class.java)
                //moveIntent.putExtra(ProfileActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
            R.id.skins_ui_button -> {
                val moveIntent = Intent(this@HomeScreen, SkinActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.logoutBtn -> {
                Log.i(TAG, "Logout")
                auth.signOut()
                googleSignInClient.signOut()
                //Auth.GoogleSignInApi.signOut()
                val logoutIntent = Intent(this, MainActivity::class.java)
                logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(logoutIntent)
            }
        }
    }
}