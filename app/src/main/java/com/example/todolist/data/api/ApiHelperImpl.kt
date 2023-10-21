package com.example.todolist.data.api

import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.modal.response.AddTodoResponse
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.AddedListingResponseData
import com.example.todolist.modal.response.LoginResponseData
import com.example.todolist.utilz.Constants
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun postLogin(
        loginRequest: LoginRequestData?
    ): Response<LoginResponseData?> = apiService.postLogin(Constants.API_KEY, loginRequest)

    override suspend fun postAddTodo(
        addTodoRequest:
        AddTodoRequest?
    ): Response<AddTodoResponse?> = apiService.postAddTodo(addTodoRequest)

    override suspend fun getAddedTodos(
        userId: String
    ): Response<AddedListingResponseData?> = apiService.getAddedTodos(userId)

}