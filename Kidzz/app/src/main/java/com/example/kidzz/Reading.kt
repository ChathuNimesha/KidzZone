package com.example.kidzz
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Reading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)

        val Buttonbr = findViewById<ImageButton>(R.id.back1)
        Buttonbr.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val s1:ImageButton =findViewById(R.id.s1)
        s1.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/004-ABE-THE-SERVICE-DOG-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589884748")
        }
        val s2:ImageButton =findViewById(R.id.s2)
        s2.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/007-HAMMY-THE-HAMSTER-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589846896")
        }
        val s3:ImageButton =findViewById(R.id.s3)
        s3.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/007-HAMMY-THE-HAMSTER-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589846896")
        }
        val s5:ImageButton =findViewById(R.id.s5)
        s5.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/007-HAMMY-THE-HAMSTER-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589846896")
        }
        val s6:ImageButton =findViewById(R.id.s6)
        s6.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/007-HAMMY-THE-HAMSTER-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589846896")
        }
        val imageButton8:ImageButton =findViewById(R.id.imageButton8)
        imageButton8.setOnClickListener{
            openWebPage("https://cdn.shopify.com/s/files/1/2081/8163/files/007-HAMMY-THE-HAMSTER-Free-Childrens-Book-By-Monkey-Pen.pdf?v=1589846896")
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
