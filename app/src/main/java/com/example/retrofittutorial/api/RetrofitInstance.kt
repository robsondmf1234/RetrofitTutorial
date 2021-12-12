package com.example.retrofittutorial.api

import com.example.retrofittutorial.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //Builder de criação do Retrofit
    private val retrofit by lazy {
        Retrofit.Builder()
            //Base de url, será o endereço Http que nosso retrofit faz a consulta
            .baseUrl(BASE_URL)
            //Conversor de json
            .addConverterFactory(GsonConverterFactory.create())
            //Construindo
            .build()
    }

    //Criando uma instancia da interface
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}