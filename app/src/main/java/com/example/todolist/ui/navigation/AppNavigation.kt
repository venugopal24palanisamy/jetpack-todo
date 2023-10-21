package com.example.todolist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolist.ui.addListing.AddListing
import com.example.todolist.ui.home.HomeListings
import com.example.todolist.ui.home.HomeScreen
import com.example.todolist.ui.login.Login
import com.example.todolist.ui.profile.Profile
import com.example.todolist.ui.register.RegisterScreen
import com.example.todolist.ui.splash.SplashScreen
import com.example.todolist.ui.welcome.WelcomeView
import com.example.todolist.ui.your_listings.YourListings
import com.example.todolist.utilz.Constants
import com.example.todolist.utilz.PreferenceHelper

@Composable
fun AppNavigation(navController: NavHostController) {
    val context = LocalContext.current
    val startDestination = if (PreferenceHelper(context).getBoolean(
            Constants.IS_LOGGED_IN,
            false
        )
    ) Screen.Home.route else Screen.Welcome.route
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Welcome.route) {
            WelcomeView(navController)
        }
        composable(Screen.Login.route) {
            Login(navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AddTodo.route) {
            AddListing(navController)
        }
        composable(Screen.HomeListing.route) {
            HomeListings(navController)
        }
        composable(Screen.YourListing.route) {
            YourListings(navController)
        }
        composable(Screen.Profile.route) {
            Profile(navController)
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