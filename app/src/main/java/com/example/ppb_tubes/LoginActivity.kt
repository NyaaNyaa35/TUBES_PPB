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
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityLoginBinding
    private lateinit var fstore: FirebaseFirestore

    companion object {
        const val EXTRA_UID = "extra_uid"
        private const val TAG = "LoginActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        fstore = FirebaseFirestore.getInstance()

        auth = Firebase.auth
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        binding.googleSignInButton.setOnClickListener {
//            Log.d(TAG,"onCreate: Begin Google Sign In")
//            val signInIntent = googleSignInClient.signInIntent
//            googleSignInActivityResultLauncher.launch(signInIntent)
//        }


        val btnLogin: Button = findViewById(R.id.button_login)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login -> {
                val hardcoded_person = Person("Test","AJG","test@email.com","123")

                username = findViewById(R.id.et_name)
                tag = findViewById(R.id.et_riottag)
                password = findViewById(R.id.et_password)

                val username_text = username.text.toString().trim()
                val tag_text = tag.text.toString().trim()
                val password_text = password.text.toString().trim()


                val userID = auth.currentUser!!.uid

//                fstore.document(EXTRA_UID).collection("users")
//                    .add(user)
//                    .addOnCompleteListener(this){
//                        if (it.isSuccessful){
//                            Log.d(TAG, "User added to database.")
//                        }
//                        Log.w(TAG, "Failed to add user to database")
//                    }
                var documentReference: DocumentReference = fstore.collection("users").document(userID)
                //fstore.collection("users").document(userID)
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
                //moveIntent.putExtra(HomeScreen.EXTRA_PERSON, hardcoded_person)
                startActivity(moveIntent)
//
//                if (username_text == hardcoded_person.username &&
//                    tag_text == hardcoded_person.tag &&
//                    password_text == hardcoded_person.password
//                ) {
//                    val moveIntent = Intent(this@LoginActivity, HomeScreen::class.java)
//                    moveIntent.putExtra(HomeScreen.EXTRA_PERSON, hardcoded_person)
//                    startActivity(moveIntent)
//                } else {
//                    val alertDialogBuilder = AlertDialog.Builder(this)
//                    alertDialogBuilder.setMessage("Wrong Account entry.\nPlease Try Again").show()
//                }
            }
        }
    }
//    private val googleSignInActivityResultLauncher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == RESULT_OK) {
//                Log.d(TAG, "onActivityResult : ${result.data!!.extras}")
//                val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
//                if (task.isSuccessful) {
//                    try {
//                        val account = task.getResult(ApiException::class.java)
//                        Log.d(TAG,"firebaseAuthWithGoogle" + account.id)
//                        firebaseAuthWithGoogleAccount(account.idToken!!)
//                        //handleSignInResult(task)
//                    } catch (e: ApiException) {
//                        Log.w(TAG,"Google Sign In Failed", e)
//                    }
//                }
//            } else {
//                Log.w(TAG, "onActivityResult : ${result.data}")
//            }
//        }
//        private fun firebaseAuthWithGoogleAccount(idToken: String) {
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnSuccessListener(this) { task ->
//                if (task.additionalUserInfo!!.isNewUser) {
//                    /** Akun Baru */
//                    updateUI(true)
//                } else {
//                    /** Akun Lama */
//                    updateUI(false)
//                }
//            }
//            .addOnFailureListener { err ->
//                Log.d(TAG, "firebaseAuthWithGoogleAccount : ${err.message}")
//                Toast.makeText(this, "${err.message}", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    private fun updateUI(isCreated: Boolean) {
//        val user = auth.currentUser!!
//
//        if (isCreated) {
//            Log.d(TAG, "firebaseAuthWithGoogleAccount : Account created ${user.email}")
//            Toast.makeText(this, "Account created ${user.email}", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, HomeScreen::class.java))
//            finish()
//        } else {
//            Log.d(TAG, "firebaseAuthWithGoogleAccount : Existing account ${user.email}")
//            Toast.makeText(this, "Existing account ${user.email}", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, HomeScreen::class.java))
//            finish()
//        }
//    }

}