package com.example.todolist.data.api

import com.example.todolist.modal.LoginRequestData
import com.example.todolist.modal.LoginResponseData
import com.example.todolist.utilz.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun postLogin(@Body loginRequest: LoginRequestData?):Response<LoginResponseData?>
}