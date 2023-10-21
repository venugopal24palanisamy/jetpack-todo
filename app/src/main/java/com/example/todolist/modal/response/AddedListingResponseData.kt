package com.example.todolist.modal.response
 data class AddedListingResponseData(
    val limit: Int,
    val skip: Int,
    val todos: List<Todo>,
    val total: Int
)
data class Todo(
    val completed: Boolean,
    val id: Int,
    val todo: String,
    val userId: Int
)