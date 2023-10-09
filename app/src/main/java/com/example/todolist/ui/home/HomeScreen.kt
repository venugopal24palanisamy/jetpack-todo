package com.example.todolist.ui.home

import android.annotation.SuppressLint


import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.height


import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold

import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

import androidx.compose.ui.Modifier


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.todolist.ui.components.AppBar
import com.example.todolist.ui.components.DrawerHeader
import com.example.todolist.ui.components.NavigationItems
import com.example.todolist.ui.components.getNavigationDrawerItems

import com.example.todolist.ui.navigation.DrawerNavigationActions

import com.example.todolist.ui.theme.Blue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    navHostController: NavHostController = rememberNavController()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val drawerItemList = getNavigationDrawerItems()
    var selectedItem = remember { mutableStateOf(drawerItemList[0].label) }.toString()
    val navigationActions = remember(navController) {
        DrawerNavigationActions(navHostController)
    }
    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Blue,
                drawerTonalElevation = 27.dp,
            ) {
                Spacer(Modifier.height(55.dp))
                DrawerHeader()
                Spacer(Modifier.height(25.dp))
                drawerItemList.forEach { it ->
                    NavigationItems(it) {
                        it.isSelected = true
                        selectedItem = it.label
                        when (selectedItem) {
                            "Home" -> navigationActions.navigateToHome()
                            "Your List" -> navigationActions.navigateToYourListing()
                            "Profile" -> navigationActions.navigateToProfile()
                        }
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }
                }
            }
        }) {
        Scaffold(topBar = {
            AppBar {
                coroutineScope.launch {
                    drawerState.open()
                }
            }
        }) {
            //DrawerRouting(navHostController,navController)


        }
    }


}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

