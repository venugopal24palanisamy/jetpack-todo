package com.example.todolist.data.api

import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.modal.response.AddTodoResponse
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.LoginResponseData
import com.example.todolist.modal.response.Todo
import com.example.todolist.utilz.Constants
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun postLogin(
        loginRequest: LoginRequestData?
    ): Response<LoginResponseData?> = apiService.postLogin(Constants.API_KEY, loginRequest)

    override suspend fun postAddTodo(
        token: String,
        id: String,
        addTodoRequest:
        AddTodoRequest?
    ): Response<AddTodoResponse?> =
        apiService.postAddTodo(token, id, Constants.API_KEY, addTodoRequest)

    override suspend fun getAddedTodos(
        token: String,
        id: String
    ): List<Todo?> = apiService.getAddedTodos(token, id, Constants.API_KEY)

}