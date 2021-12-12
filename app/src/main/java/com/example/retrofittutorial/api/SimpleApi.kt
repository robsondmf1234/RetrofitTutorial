package com.example.retrofittutorial.api

import com.example.retrofittutorial.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Interface que conterá os endpoints que precisaremos para fazer as chamadas
//
interface SimpleApi {

    //Endereço do endpoint do tipo GET
    @GET("posts/1")
    //Será ums suspend fun ,pois será uitlizado coroutines para se trabalhar com Threads paralelas
    //Receberá como retorno um objeto do tipo Post
    suspend fun getPost(): Response<Post>

    //Endpoint que enviará um number no corpo da chamada, number que virá como parametro atraves
    // da Activity> ViewModel > Repository > SimpleApi(interface)
    @GET("posts/{postNumber}")
    //postNumber
    suspend fun getPost2(@Path("postNumber") number: Int): Response<Post>


    //Endpoint que receberá como parametro um userId,
    // que será enviado na chamada
    //Receberá como retorno um Response com uma Lista do tipo Post
    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPostQueries(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

}