package com.example.todolist.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.todolist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onNavigationIconClick: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.titleMedium,
        )
    }, navigationIcon = {
        IconButton(onClick = onNavigationIconClick) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }
    })
}