package com.example.ppb_tubes

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        //var EXTRA_PERSON= "extra_person"
    }

    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var password: TextView
    private lateinit var chgPass: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var fstore: FirebaseFirestore
    private lateinit var userId: String
    private lateinit var storageref: StorageReference
    private lateinit var profileImg: CircleImageView
//    val hardcodedPerson: Person = Person("Test","AJG","test@email.com","123")
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                //val value = it.data?.getStringExtra("input")
                val imageUri: Uri = it.data!!.data as Uri
                //profileImg.setImageURI(imageUri)
                uploadImageToFirebase(imageUri)
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        //val person = intent.getParcelableExtra<Person>(EditProfileActivity.EXTRA_PERSON) as Person
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        auth = Firebase.auth
        fstore = FirebaseFirestore.getInstance()
        storageref = FirebaseStorage.getInstance().getReference()
        userId = auth.currentUser!!.uid

        username = findViewById(R.id.username)
//        username.text = person.username + "#" +person.tag
        email = findViewById(R.id.email)
//        email.text = person.email

        var documentReference: DocumentReference = fstore.collection("users").document(userId)
        documentReference.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("Data Exist", "DocumentSnapshot data: ${document.data}")
                    username.text = document.getString("username") + "#" + document.getString("tag")
                    email.text = auth.currentUser!!.email.toString()
                } else {
                    Log.d("Null","Data Doesn't Exist")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error","Failed to get", exception)
            }

        profileImg = findViewById(R.id.profile_pict)

        var fileref: StorageReference = storageref.child("users/"+userId+"/profile.jpg")

        fileref.downloadUrl.addOnSuccessListener { Uri ->
            Picasso.get().load(Uri).into(profileImg)
        }

        chgPass = findViewById(R.id.change_pass)
        chgPass.setOnClickListener(this)

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
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                getResult.launch(galleryIntent)
            }
            R.id.change_pass -> {
                val person = intent.getParcelableExtra<Person>(EditProfileActivity.EXTRA_PERSON) as Person
                val moveIntent = Intent(this@ProfileActivity, ChangePassActivity::class.java)
                moveIntent.putExtra(ChangePassActivity.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
        }

    }

    private fun uploadImageToFirebase(imageUri: Uri) {
        var fileref: StorageReference = storageref.child("users/"+userId+"/profile.jpg")
        fileref.putFile(imageUri).addOnSuccessListener {
            fileref.downloadUrl.addOnSuccessListener(){
                Picasso.get().load(imageUri).into(profileImg)
            }
        }
            .addOnFailureListener {
                Toast.makeText(this,"Failed to Upload",Toast.LENGTH_SHORT).show()
            }
    }
}