package com.example.todolist.data.api

import androidx.lifecycle.LiveData
import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.modal.response.AddTodoResponse
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.LoginResponseData
import com.example.todolist.modal.response.Todo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHelper {
    suspend fun postLogin(@Body loginRequest: LoginRequestData?): Response<LoginResponseData?>
    suspend fun postAddTodo(
        @Header("Authorization") token: String,
        @Path("user_id") id: String,
        @Body addTodoRequest: AddTodoRequest?
    ): Response<AddTodoResponse?>

    suspend fun getAddedTodos( @Header("Authorization") token: String,
                                @Path("user_id") id: String,): List<Todo?>
}