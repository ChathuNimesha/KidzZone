package com.example.kidzz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kidzz.databinding.ActivityLogin1Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Login1 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.next.setOnClickListener {

            val email = binding.email.text.toString().trim()
            val password = binding.Password.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (email == "mom@gmail.com" && password == "dad1234") {
                    // Redirect to AdminHome.kt
                    Toast.makeText(this, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, AdminHome::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val userId = firebaseAuth.currentUser?.uid ?: ""
                                saveUserToDatabase(email, userId)
                                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, Home::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                val exceptionMessage = task.exception?.message
                                Toast.makeText(this, "Login Unsuccessful: $exceptionMessage", Toast.LENGTH_LONG).show()
                            }
                        }
                }
            } else {
                Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show()
            }
        }
        // Adding functionality for the "back" button
        binding.back.setOnClickListener {
            val intent = Intent(this, Signup1::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveUserToDatabase(email: String, userId: String) {
        val user = User(email, userId)
        val reference = database.getReference("users").child(userId)
        reference.setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "User saved to database", Toast.LENGTH_SHORT).show()
            } else {
                val exceptionMessage = task.exception?.message
                Toast.makeText(this, "Failed to save user: $exceptionMessage", Toast.LENGTH_LONG).show()
            }
        }
    }
}
