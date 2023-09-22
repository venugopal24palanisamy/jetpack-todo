package com.example.todolist.data.api

import com.example.todolist.modal.LoginRequestData
import com.example.todolist.modal.LoginResponseData
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun postLogin(loginRequest: LoginRequestData?): Response<LoginResponseData?> =
        apiService.postLogin(loginRequest)
}