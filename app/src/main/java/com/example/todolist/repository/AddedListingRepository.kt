package com.example.todolist.repository

import com.example.todolist.data.api.ApiHelper
import javax.inject.Inject

class AddedListingRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getAddedUserTodos(token: String?, id: String?) = apiHelper.getAddedTodos(token!!, id!!)
}