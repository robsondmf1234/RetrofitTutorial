package com.example.retrofittutorial.model

//Classe modelo ,que será a base do que receberemos no response

//Endpoint https://jsonplaceholder.typicode.com/posts/1
//Criaremos nossa classe com base no que receberemos como resposta no endpoint acima
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
