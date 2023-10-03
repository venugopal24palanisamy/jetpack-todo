package com.example.todolist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.ui.addListing.AddListing
import com.example.todolist.ui.home.HomeListings
import com.example.todolist.ui.home.HomeScreen
import com.example.todolist.ui.login.Login
import com.example.todolist.ui.profile.Profile
import com.example.todolist.ui.welcome.WelcomeView
import com.example.todolist.ui.your_listings.YourListings

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeView(navController)
        }
        composable(Screen.Login.route) {
            Login(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AddTodo.route) {
            AddListing(navController)
        }
    }
}

@Composable
fun DrawerRouting(navHostController: NavHostController,
                  navController: NavController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeListing.route,
    ) {
        composable(Screen.HomeListing.route) {
            HomeListings(navHostController,navController)
        }
        composable(Screen.YourListing.route) {
            YourListings(navHostController,navController)
        }
        composable(Screen.Profile.route) {
            Profile(navHostController,navController)
        }

    }
}

class DrawerNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(Screen.HomeListing.route) {
            popUpTo(Screen.HomeListing.route)
        }
    }

    fun navigateToYourListing() {
        navController.navigate(Screen.YourListing.route) {
            popUpTo(Screen.YourListing.route)
        }
    }

    fun navigateToProfile() {
        navController.navigate(Screen.Profile.route) {
            launchSingleTop = true
            restoreState = true
        }
    }
}