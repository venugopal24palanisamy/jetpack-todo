package com.example.todolist.modal.request

data class AddTodoRequest(
    val description: String?,
    val completed: Boolean,
)
