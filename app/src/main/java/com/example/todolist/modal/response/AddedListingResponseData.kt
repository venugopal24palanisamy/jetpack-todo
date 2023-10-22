package com.example.todolist.modal.response

data class Todo(
    val completed: Int,
    val id: Int,
    val author: String,
    val description: String,
    val user_id: Int
)