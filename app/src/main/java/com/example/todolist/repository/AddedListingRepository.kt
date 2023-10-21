package com.example.todolist.repository

import com.example.todolist.data.api.ApiHelper
import javax.inject.Inject

class AddedListingRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getAddedUserTodos(id: String) = apiHelper.getAddedTodos(id)
}