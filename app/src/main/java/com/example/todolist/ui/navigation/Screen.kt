package com.example.todolist.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Welcome : Screen("welcome_screen")
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Home : Screen("home_screen")
    object HomeListing : Screen("home_listing_screen")
    object YourListing : Screen("your_listing_screen")
    object Profile : Screen("profile_screen")
    object AddTodo : Screen("add_todo_screen")
}
