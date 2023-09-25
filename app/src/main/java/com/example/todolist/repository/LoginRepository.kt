package com.example.todolist.repository

import com.example.todolist.data.api.ApiHelper
import com.example.todolist.modal.LoginRequestData
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun loginUser(requestData: LoginRequestData) = apiHelper.postLogin(requestData)
}