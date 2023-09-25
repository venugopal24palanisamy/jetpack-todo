package com.example.todolist.data.api

import com.example.todolist.modal.LoginRequestData
import com.example.todolist.modal.LoginResponseData
import retrofit2.Response
import retrofit2.http.Body

interface ApiHelper {
    suspend fun postLogin(@Body loginRequest: LoginRequestData?): Response<LoginResponseData?>
}