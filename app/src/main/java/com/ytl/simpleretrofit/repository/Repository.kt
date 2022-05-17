package com.ytl.simpleretrofit.repository

import com.ytl.simpleretrofit.api.RetrofitInstance
import com.ytl.simpleretrofit.model.OnlineData
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<OnlineData> {
        return RetrofitInstance.api.getPost()
    }

}