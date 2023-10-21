package com.example.todolist.data.api

import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.modal.response.AddTodoResponse
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.AddedListingResponseData
import com.example.todolist.modal.response.LoginResponseData
import com.example.todolist.utilz.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun postLogin(
        @Query("apikey") apikey: String,
        @Body loginRequest: LoginRequestData?
    ): Response<LoginResponseData?>

    @POST(Constants.ADD_TODO_ENDPOINT)
    suspend fun postAddTodo(@Body addTodoRequest: AddTodoRequest?): Response<AddTodoResponse?>

    @GET(Constants.GET_ALL_TODO_BY_USER_ID)
    suspend fun getAddedTodos(@Path("id") id: String): Response<AddedListingResponseData?>

}