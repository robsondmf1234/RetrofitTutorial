package com.example.retrofittutorial.api

import com.example.retrofittutorial.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//Interface conterá os endpoints que precisaremos para fazer as chamadas
//
interface SimpleApi {

    //Endereço do endpoint do tipo GET
    @GET("posts/1")
    //Será ums suspend fun ,pois será uitlizado coroutines para se trabalhar com Threads paralelas
    //Receberá como retorno um objeto do tipo Post
    suspend fun getPost(): Response<Post>


    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>
}