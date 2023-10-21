package com.example.todolist.data.api

import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.modal.response.AddTodoResponse
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.AddedListingResponseData
import com.example.todolist.modal.response.LoginResponseData
import retrofit2.Response
import retrofit2.http.Body

interface ApiHelper {
    suspend fun postLogin(@Body loginRequest: LoginRequestData?): Response<LoginResponseData?>
    suspend fun postAddTodo(@Body addTodoRequest: AddTodoRequest?): Response<AddTodoResponse?>
    suspend fun getAddedTodos(id: String): Response<AddedListingResponseData?>
}