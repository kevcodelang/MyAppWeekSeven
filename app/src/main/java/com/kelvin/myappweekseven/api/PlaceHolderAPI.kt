package com.kelvin.myappweekseven.api

import com.kelvin.myappweekseven.models.User
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {
    @GET("users")
    fun getUsers(): Call<List<User>>
}