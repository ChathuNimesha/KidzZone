package com.example.kidzz

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Watching : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watching)

        val imageButton = findViewById<ImageButton>(R.id.imageButtonb)
        imageButton.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val s1:ImageButton =findViewById(R.id.s1)
        s1.setOnClickListener{
            openWebPage("https://youtu.be/YvVdIEL0XMM?si=kYqvxufzGX6YsDAt")
        }
        val s2:ImageButton =findViewById(R.id.s2)
        s2.setOnClickListener{
            openWebPage("https://youtu.be/X8f4y51qC6M?si=A2DpsutFEtuA3E7I")
        }
        val s3:ImageButton =findViewById(R.id.s3)
        s3.setOnClickListener{
            openWebPage("https://youtu.be/m9vU3f3QVW4?si=nyN00WtYRRLLxg0j")
        }
        val s5:ImageButton =findViewById(R.id.s5)
        s5.setOnClickListener{
            openWebPage("https://youtu.be/m9vU3f3QVW4?si=nyN00WtYRRLLxg0j")
        }
        val s6:ImageButton =findViewById(R.id.s6)
        s6.setOnClickListener{
            openWebPage("https://youtu.be/m9vU3f3QVW4?si=nyN00WtYRRLLxg0j")
        }
        val imageButton8:ImageButton =findViewById(R.id.imageButton8)
        imageButton8.setOnClickListener{
            openWebPage("https://youtu.be/m9vU3f3QVW4?si=nyN00WtYRRLLxg0j")
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
