package com.example.todolist.utilz

import androidx.compose.ui.unit.dp

object Constants {

    const val SPLASH_SCREEN_DURATION = 0L
    const val API_KEY = "7c619d23-63c8-4b84-a68e-985cd832b7f7"
    const val BASE_URL = "https://todos.simpleapi.dev/"

    //API End Points

    const val LOGIN_ENDPOINT = "api/users/login"

    const val ADD_TODO_ENDPOINT = "api/users/{user_id}/todos"
    const val GET_ALL_TODO_BY_USER_ID = "api/users/{user_id}/todos"


    const val IS_LOGGED_IN = "isLoggedIn"
    const val USER_NAME = "user_name"
    const val USER_ID = "user_id"
    const val USER_TOKEN = "user_token"
    const val USER_IMAGE = "user_image"

    val DrawerWidth = 300.dp

}