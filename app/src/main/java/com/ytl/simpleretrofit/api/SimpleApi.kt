package com.ytl.simpleretrofit.api

import com.ytl.simpleretrofit.model.OnlineData
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<OnlineData>
}