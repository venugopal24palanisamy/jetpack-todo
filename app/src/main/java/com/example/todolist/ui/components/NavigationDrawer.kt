package com.example.todolist.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List

import com.example.todolist.ui.navigation.MenuItems



fun getNavigationDrawerItems(): List<MenuItems> {
    val menuItems = ArrayList<MenuItems>()
    menuItems.add(MenuItems("Home", icon = Icons.Default.Home,false))
    menuItems.add(MenuItems("Your List", icon = Icons.Default.List,false))
    menuItems.add(MenuItems("Profile", icon = Icons.Default.AccountCircle,false))
    return menuItems
}