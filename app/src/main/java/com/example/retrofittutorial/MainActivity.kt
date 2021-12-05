package com.example.retrofittutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittutorial.databinding.ActivityMainBinding
import com.example.retrofittutorial.repository.Repository
import com.example.retrofittutorial.viewmodel.MainViewModel
import com.example.retrofittutorial.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

/*
        //GET
        //post

        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                Log.d("Response", response.body()?.title!!)
                Log.d("Response", response.body()?.body!!)
                binding.textView.text = response.body()?.body
            } else {
                Log.d("Response", response.errorBody().toString())
                binding.textView.text = response.code().toString()
            }
        })
*/

        binding.btnOk.setOnClickListener {
            val numberPost = binding.edtNumber.text.toString()

            viewModel.getPost2(Integer.parseInt(numberPost))

            viewModel.myResponse2.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.textView.text = response.body()?.body

                    Log.d("Response", response.body()?.userId.toString())
                    Log.d("Response", response.body()?.id.toString())
                    Log.d("Response", response.body()?.title!!)
                    Log.d("Response", response.body()?.body!!)
                } else {
                    Log.d("Response", response.errorBody().toString())
                    binding.textView.text = response.code().toString()
                }
            })

        }
    }
}