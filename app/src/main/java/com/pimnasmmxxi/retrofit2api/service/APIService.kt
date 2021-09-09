package com.pimnasmmxxi.retrofit2api.service

import com.pimnasmmxxi.retrofit2api.model.ResponseResult
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/api/v1/food-comps")
    suspend fun getDataNested(): Response<ResponseResult>
}