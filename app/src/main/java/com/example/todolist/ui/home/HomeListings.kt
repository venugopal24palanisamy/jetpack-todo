package com.example.todolist.ui.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.todolist.ui.components.FloatingAddButton
import com.example.todolist.ui.components.TodoTile
import com.example.todolist.ui.navigation.Screen
import com.example.todolist.utilz.Status

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun HomeListings(
    navController: NavHostController
) {
    val context = LocalContext.current
    val homeViewModel: HomeListingViewModel = hiltViewModel()
    homeViewModel.getAddedToDoData(context, "5")
    val scope = rememberCoroutineScope()

    val addedData by homeViewModel.getAddedTodoLiveData.observeAsState()
    val toDoList by homeViewModel.getAddedTodoLiveLiveData.observeAsState()

    when (addedData?.status) {
        Status.LOADING -> {}
        Status.SUCCESS -> {

        }

        Status.ERROR -> {

        }

        else -> {}
    }
    Scaffold(floatingActionButton = {
        AnimatedVisibility(
            visible = true,
            enter = scaleIn(),
            exit = scaleOut(),
        ) {
            FloatingAddButton {
                navController.navigate(Screen.AddTodo.route)
            }
        }
    }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(55.dp))
            toDoList?.let {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.padding(6.dp)
                ) {
                    items(toDoList!!.size) {
                        TodoTile(toDoList!![it].todo,
                            onItemClicked = {

                            }, onDeleteClicked = {

                            })
                    }
                }
            } ?: Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "No ToDo Data Available",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp, modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomeListingsPreview() {

}