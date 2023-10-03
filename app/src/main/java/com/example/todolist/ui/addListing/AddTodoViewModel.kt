package com.example.todolist.ui.addListing

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.R
import com.example.todolist.modal.AddTodoRequest
import com.example.todolist.modal.AddTodoResponse
import com.example.todolist.repository.AddTodoRepository
import com.example.todolist.utilz.NetworkHelper
import com.example.todolist.utilz.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTodoViewModel @Inject constructor(private val addTodoRepository: AddTodoRepository) :
    ViewModel() {
    private val addTodo = MutableLiveData<Resource<AddTodoResponse>>()
    val addTodoData: LiveData<Resource<AddTodoResponse>>
        get() = addTodo

    fun addToDoFromUser(
        context: Context,
        addTodoRequestData: AddTodoRequest
    ) {
        viewModelScope.launch {
            addTodo.postValue(Resource.loading(null))
            if (NetworkHelper(context).isNetworkConnected()) addTodoRepository.addTodo(
                addTodoRequestData
            )
                .let {
                    if (it.isSuccessful)
                        addTodo.postValue(Resource.success(it.body()))
                    else addTodo.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }
            else addTodo.postValue(
                Resource.error(
                    context.getString(R.string.no_internet_connection),
                    null
                )
            )

        }
    }
}