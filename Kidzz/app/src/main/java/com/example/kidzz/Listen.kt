package com.example.kidzz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Listen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        val imageButtonW = findViewById<ImageButton>(R.id.imageButtonw)
        imageButtonW.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val s1:ImageButton =findViewById(R.id.s1)
        s1.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
        val s2:ImageButton =findViewById(R.id.s2)
        s2.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
        val s3:ImageButton =findViewById(R.id.s3)
        s3.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
        val s5:ImageButton =findViewById(R.id.s5)
        s5.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
        val s6:ImageButton =findViewById(R.id.s6)
        s6.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
        val imageButton8:ImageButton =findViewById(R.id.imageButton8)
        imageButton8.setOnClickListener{
            openWebPage("https://moonzia.com/the-magical-hat-story/")
        }
    }
    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW,webpage)
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}
