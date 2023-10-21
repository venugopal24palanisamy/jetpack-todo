package com.example.todolist.modal.response

data class LoginResponseData(
    val email: String,
    val name: String,
    val id: Int,
    val token: String,
)