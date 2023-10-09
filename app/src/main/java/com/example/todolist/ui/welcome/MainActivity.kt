package com.example.todolist.ui.welcome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.components.AppBar
import com.example.todolist.ui.components.DrawerHeader
import com.example.todolist.ui.components.NavigationItems
import com.example.todolist.ui.components.getNavigationDrawerItems
import com.example.todolist.ui.navigation.AppNavigation
import com.example.todolist.ui.navigation.DrawerNavigationActions
import com.example.todolist.ui.theme.Blue


import com.example.todolist.ui.theme.TodoListTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val coroutineScope = rememberCoroutineScope()
                val drawerItemList = getNavigationDrawerItems()
                var selectedItem = remember { mutableStateOf(drawerItemList[0].label) }.toString()
                val navigationActions = remember(navController) {
                    DrawerNavigationActions(navController)
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
                         AppNavigation(navController)
                    }
                }
            }
        }
    }
}


