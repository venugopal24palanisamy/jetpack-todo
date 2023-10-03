package com.example.todolist.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

import com.example.todolist.ui.navigation.MenuItems
import com.example.todolist.ui.theme.Blue


@Composable
fun NavigationItems(
    menuItems: MenuItems, onItemClick: (MenuItems) -> Unit
) {
    Column(modifier = Modifier.padding(start = 10.dp)) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (menuItems.isSelected) Color.White else Blue
            ),
            shape = RoundedCornerShape(
                topStart = 25.dp,
                bottomStart = 25.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp
            ), modifier = Modifier
                .padding(start = 10.dp)
                .clickable { onItemClick(menuItems) }
        ) {
            Box(
                modifier = Modifier.padding(10.dp),
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = menuItems.icon,
                        contentDescription = "",
                        tint = if (menuItems.isSelected) Blue else Color.White
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        color = if (menuItems.isSelected) Blue else Color.White,
                        text = menuItems.label,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
    }
}