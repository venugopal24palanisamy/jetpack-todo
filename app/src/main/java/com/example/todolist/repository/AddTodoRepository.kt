package com.example.todolist.repository

import com.example.todolist.data.api.ApiHelper
import com.example.todolist.modal.request.AddTodoRequest
import javax.inject.Inject

class AddTodoRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun addTodo(token: String?, userId: String?, requestData: AddTodoRequest) =
        apiHelper.postAddTodo(token!!, userId!!, requestData)
}