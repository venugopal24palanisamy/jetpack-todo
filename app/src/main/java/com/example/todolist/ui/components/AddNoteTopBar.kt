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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todolist.R
import com.example.todolist.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteTopBar(
    navigateBack: () -> Unit,
    title: String,
    notes: String,
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
        ),actions = {
            IconButton(onClick = {
                if (title.isNotEmpty() || notes.isNotEmpty()){
                   //val noteModel = NoteModel(id = 0, title = title, notes = notes)
                    //viewModel.insertNote(noteModel)
                    navigateBack()
                }else{
                    navigateBack()
                }
            }) {
                Icon(painterResource(id = R.drawable.baseline_done),
                    contentDescription = "Done", tint = Color.White
                )
            }
        }
    )
}