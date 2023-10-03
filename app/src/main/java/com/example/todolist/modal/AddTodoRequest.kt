package com.example.todolist.modal

data class AddTodoRequest(
    val todo: String?,
    val completed: Boolean,
    val userId: String?
)
