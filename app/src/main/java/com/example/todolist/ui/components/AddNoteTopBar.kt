package com.example.todolist.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.todolist.R
import com.example.todolist.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteTopBar(
    navigateBack: () -> Unit,
    addNotes: () -> Unit
) {

    TopAppBar(
        title = {

        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    painterResource(id = R.drawable.baseline_arrow_back),
                    contentDescription = "Close"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Blue,
            navigationIconContentColor = Color.White
        ), actions = {
            IconButton(onClick = {
                addNotes()
                //navigateBack()
            }) {
                Icon(
                    painterResource(id = R.drawable.baseline_done),
                    contentDescription = "Done", tint = Color.White
                )
            }
        }
    )
}