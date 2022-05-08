package com.example.ppb_tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ppb_tubes.databinding.ActivityLoginBinding
import com.example.ppb_tubes.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var username: EditText
    private lateinit var tag: EditText
    private lateinit var password: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityMainBinding

    private companion object {
        private const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.googleSignInButton.setOnClickListener {
            Log.d(TAG,"onCreate: Begin Google Sign In")
            val signInIntent = googleSignInClient.signInIntent
            googleSignInActivityResultLauncher.launch(signInIntent)
        }

//        val btnLogin: Button = findViewById(R.id.button_login_main)
//        btnLogin.setOnClickListener(this)

        //val btnRegister: Button = findViewById(R.id.button_register_main)
        //btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
//            R.id.button_login_main -> {
//                val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
//                startActivity(loginIntent)
//            }
//            R.id.button_register_main -> {
//                val registerIntent = Intent(this@MainActivity, RegisterActivity::class.java)
//                startActivity(registerIntent)
//            }
        }
    }

    private val googleSignInActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.d(TAG, "onActivityResult : ${result.data!!.extras}")
                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    try {
                        val account = task.getResult(ApiException::class.java)
                        Log.d(TAG,"firebaseAuthWithGoogle" + account.id)
                        firebaseAuthWithGoogleAccount(account.idToken!!)
                        //handleSignInResult(task)
                    } catch (e: ApiException) {
                        Log.w(TAG,"Google Sign In Failed", e)
                    }
                }
            } else {
                Log.w(TAG, "onActivityResult : ${result.data}")
            }
        }

    private fun firebaseAuthWithGoogleAccount(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener(this) { task ->
                if (task.additionalUserInfo!!.isNewUser) {
                    /** Akun Baru */
                    updateUI(true)
                } else {
                    /** Akun Lama */
                    updateUI(false)
                }
            }
            .addOnFailureListener { err ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount : ${err.message}")
                Toast.makeText(this, "${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUI(isCreated: Boolean) {
        val user = auth.currentUser!!

        if (isCreated) {
            Log.d(TAG, "firebaseAuthWithGoogleAccount : Account created ${user.email}")
            Toast.makeText(this, "Account created ${user.email}", Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(this, LoginActivity::class.java)
            moveIntent.putExtra(LoginActivity.EXTRA_UID, user.uid)
            startActivity(moveIntent)
            //startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            Log.d(TAG, "firebaseAuthWithGoogleAccount : Existing account ${user.email}")
            Toast.makeText(this, "Existing account ${user.email}", Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(this, HomeScreen::class.java)
            moveIntent.putExtra(HomeScreen.EXTRA_UID, user.uid)
            startActivity(moveIntent)
            //startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}