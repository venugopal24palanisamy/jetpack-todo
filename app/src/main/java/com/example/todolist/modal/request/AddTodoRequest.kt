package com.example.todolist.modal.request

data class AddTodoRequest(
    val todo: String?,
    val completed: Boolean,
    val userId: String?
)
