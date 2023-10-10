package com.example.todolist.ui.addListing

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todolist.R
import com.example.todolist.modal.AddTodoRequest
import com.example.todolist.ui.components.AddNoteTopBar
import com.example.todolist.ui.navigation.Screen
import com.example.todolist.ui.theme.Blue
import com.example.todolist.utilz.MyFunctions
import com.example.todolist.utilz.Status

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddListing(
    navHostController: NavHostController
) {
    val viewModel: AddTodoViewModel = hiltViewModel()
    var notes by remember { mutableStateOf("") }
    val context = LocalContext.current

    val addedToDoData by viewModel.addTodoData.observeAsState()
    when (addedToDoData?.status) {
        Status.LOADING -> {}
        Status.SUCCESS -> {
            //navHostController.popBackStack()
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
        }

        Status.ERROR -> {

        }

        else -> {}
    }

    Scaffold(
        Modifier.background(color = Blue),
        topBar = {
            AddNoteTopBar(
                navigateBack = { navHostController.popBackStack() },
                addNotes = {
                    viewModel.addToDoFromUser(
                        context,
                        AddTodoRequest(notes, false, "5")
                    )
                }
            )
        },
    ) {
        Surface(color = Blue) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp)
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = stringResource(id = R.string.notes),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    placeholder = {
                        Text(
                            "Notes",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        disabledIndicatorColor = Color.Transparent,
                        containerColor = Blue
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                    ),
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AddListingPreView() {
}