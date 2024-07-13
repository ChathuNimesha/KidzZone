package com.example.kidzz

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FormAdd : AppCompatActivity() {

    private lateinit var editTextImageLink: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonUploadImage: ImageButton
    private lateinit var databaseRef: DatabaseReference

    companion object {
        const val REQUEST_CODE_PICK_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_add)

        editTextImageLink = findViewById(R.id.editTextImageLink)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        buttonUploadImage = findViewById(R.id.buttonUploadImage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Firebase Database reference
        databaseRef = FirebaseDatabase.getInstance().reference

        buttonUploadImage.setOnClickListener {
            openGallery()
        }

        buttonSubmit.setOnClickListener {
            val imageLink = editTextImageLink.text.toString()
            if (imageLink.isNotEmpty()) {
                // Push data to Firebase Database
                val uploadData = UploadData(imageLink)
                val uploadRef = databaseRef.child("uploads").push()
                uploadRef.setValue(uploadData)
                    .addOnSuccessListener {
                        // Data successfully written to Firebase
                        setResult(Activity.RESULT_OK)
                        finish()
                    }
                    .addOnFailureListener {
                        // Handle any errors
                        // Optionally, show an error message
                    }
            }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            val selectedImageUri: Uri? = data?.data
            selectedImageUri?.let {
                editTextImageLink.setText(it.toString())
            }
        }
    }
}
