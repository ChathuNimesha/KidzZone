package com.example.kidzz
import retrofit2.Call
import retrofit2.http.GET
import com.google.gson.annotations.SerializedName





interface QuoteApi {
    @GET("random")
    fun getRandomQuote(): Call<List<ApiService>>
}



data class ApiService(
    @SerializedName("q") val quote: String,
    @SerializedName("a") val author: String,
    @SerializedName("i") val imageUrl:String
)
