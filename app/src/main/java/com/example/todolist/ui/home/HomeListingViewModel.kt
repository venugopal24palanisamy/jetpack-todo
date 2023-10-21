package com.example.todolist.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.R
import com.example.todolist.modal.response.AddedListingResponseData
import com.example.todolist.modal.response.Todo
import com.example.todolist.repository.AddedListingRepository
import com.example.todolist.utilz.NetworkHelper
import com.example.todolist.utilz.Resource
import com.example.todolist.utilz.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListingViewModel @Inject constructor(private val addedListingRepository: AddedListingRepository) :
    ViewModel() {


    private val getAddedToDoData = MutableLiveData<Resource<AddedListingResponseData>>()
    val getAddedTodoLiveData: LiveData<Resource<AddedListingResponseData>>
        get() = getAddedToDoData


    private val getAddedToDoListData = MutableLiveData<List<Todo>>()
    val getAddedTodoLiveLiveData: LiveData<List<Todo>>
        get() = getAddedToDoListData

    fun getAddedToDoData(context: Context, userId: String) {
        viewModelScope.launch {
            getAddedToDoData.postValue(Resource.loading(null))
            if (NetworkHelper(context).isNetworkConnected()) addedListingRepository.getAddedUserTodos(
                userId
            ).let {
                if (it.isSuccessful) {
                    getAddedToDoData.postValue(Resource.success(it.body()))
                    getAddedToDoListData.postValue(it.body()?.todos)
                } else getAddedToDoData.postValue(
                    Resource.error(
                        it.errorBody().toString(),
                        null
                    )
                )
            }
            else getAddedToDoData.postValue(
                Resource.error(
                    context.getString(R.string.no_internet_connection),
                    null
                )
            )

        }
    }
}