package com.example.todolist.data.api

import com.example.todolist.modal.AddTodoRequest
import com.example.todolist.modal.AddTodoResponse
import com.example.todolist.modal.LoginRequestData
import com.example.todolist.modal.LoginResponseData
import com.example.todolist.utilz.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun postLogin(
        @Body loginRequest: LoginRequestData?
    ): Response<LoginResponseData?>

    @POST(Constants.ADD_TODO_ENDPOINT)
    suspend fun postAddTodo(
        @Body addTodoRequest: AddTodoRequest?
    ): Response<AddTodoResponse?>
}