package com.example.retrofittutorial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorial.model.Post
import com.example.retrofittutorial.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse3: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myResponse4: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response2 = repository.getPost2(number)
            myResponse2.value = response2
        }
    }

    fun getCustomPosts(userId: Int) {
        viewModelScope.launch {
            val response3 = repository.getCustomPosts(userId)
            myResponse3.value = response3
        }
    }

    fun getCustomPostsQueries(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response4 = repository.getCustomPostsWithQueries(userId, sort, order)
            myResponse4.value = response4
        }
    }
}