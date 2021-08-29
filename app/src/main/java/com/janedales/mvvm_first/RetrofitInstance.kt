package com.janedales.mvvm_first

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    /**
     * Create an instance of Retrofit object
     */
    fun getRetrofitInstance(): Retrofit {
        if (retrofit == null) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val builder = OkHttpClient.Builder()

            val client: OkHttpClient = builder.addInterceptor(interceptor).build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!
    }

}