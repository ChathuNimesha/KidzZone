package com.example.kidzz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {
    private lateinit var quoteTextView: TextView
    private lateinit var authorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main2)
        quoteTextView = findViewById(R.id.quoteTextView)
        authorTextView = findViewById(R.id.authorTextView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val quoteApi = retrofit.create(QuoteApi::class.java)
        quoteApi.getRandomQuote().enqueue(object : Callback<List<ApiService>> {
            override fun onResponse(call: Call<List<ApiService>>, response: Response<List<ApiService>>) {
                if (response.isSuccessful && response.body() != null) {
                    val quoteResponse = response.body()!![0]
                    quoteTextView.text = quoteResponse.quote
                    authorTextView.text = quoteResponse.author
                }
            }

            override fun onFailure(call: Call<List<ApiService>>, t: Throwable) {
                // Handle the error
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.login)
        button.setOnClickListener {
            val intent = Intent(this, Login1::class.java)
            startActivity(intent)
        }

        val buttons = findViewById<Button>(R.id.sign)
        buttons.setOnClickListener {
            val intent = Intent(this, Signup1::class.java)
            startActivity(intent)
        }
    }
}



