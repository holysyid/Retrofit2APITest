package com.pimnasmmxxi.retrofit2api.service

import com.pimnasmmxxi.retrofit2api.model.ResponseResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {

    @Headers(
        "Accept:*/*",
        "Accept-Encoding:gzip, deflate, br",
        "Content-Type:application/json",
        "Connection:keep-alive"
    )

    @GET("/api/v1/food-comps")
    suspend fun getDataNested(): Response<ResponseResult>
}