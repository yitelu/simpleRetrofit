package com.ytl.simpleretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ytl.simpleretrofit.model.OnlineData
import com.ytl.simpleretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<OnlineData>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response: Response<OnlineData> = repository.getPost()
            myResponse.value = response
        }
    }

}