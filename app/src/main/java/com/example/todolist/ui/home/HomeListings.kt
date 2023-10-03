package com.example.todolist.ui.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.todolist.ui.components.FloatingAddButton
import com.example.todolist.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun HomeListings(
    navHostController: NavHostController,
    navController: NavController
) {
    Scaffold(floatingActionButton = {
        AnimatedVisibility(
            visible = true,
            enter = scaleIn(),
            exit = scaleOut(),
        ) {
            FloatingAddButton {
                navController.navigate(Screen.AddTodo.route)
            }
        }

    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Listing", style = MaterialTheme.typography.headlineMedium)
            Text(
                text = "This place will soon have a design",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeListingsPreview() {

}