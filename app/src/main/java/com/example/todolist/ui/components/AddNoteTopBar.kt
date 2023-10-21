package com.example.todolist.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todolist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteTopBar(
    navigateBack: () -> Unit,
    addNotes: () -> Unit
) {
    TopAppBar(
        title = {
           /* Text(
            text = stringResource(id = R.string.notes),

            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )*/
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    painterResource(id = R.drawable.baseline_arrow_back),
                    contentDescription = "Close"
                )
            }
        }, actions = {
            IconButton(onClick = {
                addNotes()
            }) {
                Icon(
                    painterResource(id = R.drawable.baseline_done),
                    contentDescription = "Done"
                )
            }
        }
    )
}