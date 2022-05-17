package com.ytl.simpleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ytl.simpleretrofit.repository.Repository

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvText = findViewById<TextView>(R.id.tvText)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d(TAG, "onCreate: userID: ${response.body()?.userId.toString()}")
                Log.d(TAG, "onCreate: id: ${response.body()?.id.toString()}")
                Log.d(TAG, "onCreate: title: ${response.body()?.title}")
                tvText.text = response.body()?.title
                Log.d(TAG, "onCreate: body: ${response.body()?.body}")
            } else{
                Log.d(TAG, "onCreate: ERROR!!! ${response.errorBody().toString()}")
                tvText.text = response.code().toString()
            }
        })
    }
}