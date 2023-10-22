package com.example.todolist.ui.addListing

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todolist.modal.request.AddTodoRequest
import com.example.todolist.ui.components.AddNoteTopBar

import com.example.todolist.utilz.Status
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddListing(
    navHostController: NavHostController
) {
    val viewModel: AddTodoViewModel = hiltViewModel()
    var notes by remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val addedToDoData by viewModel.addTodoData.observeAsState()
    when (addedToDoData?.status) {
        Status.LOADING -> {}
        Status.SUCCESS -> {
            scope.launch {
                Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
                delay(2000)
                navHostController.popBackStack()
            }
        }

        Status.ERROR -> {

        }

        else -> {}
    }

    Scaffold(
        topBar = {
            AddNoteTopBar(
                navigateBack = { navHostController.popBackStack() },
                addNotes = {
                    viewModel.addToDoFromUser(
                        context,
                        AddTodoRequest(notes, false)
                    )
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            Spacer(modifier = Modifier.height(55.dp))

            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                placeholder = {
                    Text(
                        "Notes",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                ),
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AddListingPreView() {
}