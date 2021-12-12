package com.example.retrofittutorial.repository

import com.example.retrofittutorial.api.RetrofitInstance
import com.example.retrofittutorial.model.Post
import retrofit2.Response

//Classe Repository será chamada e utilizada em nossa viewModel.
//Utilizaremos os métodos como suspend fun ,para utilizarmos coroutines
//Cada método utilizará nosso objeto RetrofitInstance,
// que chamará a SimpleApi que fará a chamada em nossos endpoints
class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId)
    }

    suspend fun getCustomPostsWithQueries(
        userId: Int,
        sort: String,
        order: String
    ): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPostQueries(userId, sort, order)
    }
}