package com.example.kidzz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Awatch : AppCompatActivity() {
    private var isDeleteMode = false
    private val selectedButtons = mutableListOf<ImageButton>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_awatch)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back1 = findViewById<ImageButton>(R.id.back1)
        back1.setOnClickListener {
            val intent = Intent(this, AdminHome::class.java)
            startActivity(intent)
        }

        val deleteButton = findViewById<ImageButton>(R.id.delete)
        deleteButton.setOnClickListener {
            isDeleteMode = !isDeleteMode
            val message = if (isDeleteMode) "Select images to delete" else "Delete mode off"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            if (!isDeleteMode) {
                deleteSelectedButtons()
            }
        }

        val addButton = findViewById<ImageButton>(R.id.add)
        addButton.setOnClickListener {
            val intent = Intent(this, FormAdd::class.java)
            startActivity(intent)
        }

        val imageButtons = listOf(
            findViewById<ImageButton>(R.id.s1),
            findViewById<ImageButton>(R.id.s2),
            findViewById<ImageButton>(R.id.s3),
            findViewById<ImageButton>(R.id.s5),
            findViewById<ImageButton>(R.id.s6),
            findViewById<ImageButton>(R.id.imageButton8)
        )

        imageButtons.forEach { button ->
            button.setOnClickListener {
                if (isDeleteMode) {
                    toggleSelection(button)
                }
            }
        }
    }

    private fun toggleSelection(button: ImageButton) {
        if (selectedButtons.contains(button)) {
            selectedButtons.remove(button)
            button.alpha = 1.0f // Deselect visual cue
        } else {
            selectedButtons.add(button)
            button.alpha = 0.5f // Select visual cue
        }
    }

    private fun deleteSelectedButtons() {
        selectedButtons.forEach { button ->
            (button.parent as? ConstraintLayout)?.removeView(button)
        }
        selectedButtons.clear()
    }
}
