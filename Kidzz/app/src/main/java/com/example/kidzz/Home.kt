package com.example.kidzz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val readM = findViewById<Button>(R.id.readM)
        readM.setOnClickListener {
            val intent = Intent(this, Reading::class.java)
            startActivity(intent)
        }

        val watchM = findViewById<Button>(R.id.watchM)
        watchM.setOnClickListener {
            val intent = Intent(this, Watching::class.java)
            startActivity(intent)
        }

        val listenM = findViewById<Button>(R.id.listenM)
        listenM.setOnClickListener {
            val intent = Intent(this, Listen::class.java)
            startActivity(intent)
        }
        val imageButton = findViewById<ImageButton>(R.id.imageButtonh)
        imageButton.setOnClickListener {
            val intent = Intent(this,MainActivity2 ::class.java)
            startActivity(intent)
        }
    }
}
