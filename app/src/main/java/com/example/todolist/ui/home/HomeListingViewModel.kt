package com.example.todolist.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.modal.response.Todo
import com.example.todolist.repository.AddedListingRepository
import com.example.todolist.utilz.Constants
import com.example.todolist.utilz.NetworkHelper
import com.example.todolist.utilz.PreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListingViewModel @Inject constructor(private val addedListingRepository: AddedListingRepository) :
    ViewModel() {





    private val getAddedToDoListData = MutableLiveData<List<Todo?>>()
    val getAddedTodoLiveLiveData: LiveData<List<Todo?>>
        get() = getAddedToDoListData

    fun getAddedToDoData(context: Context) {
        viewModelScope.launch {
            if (NetworkHelper(context).isNetworkConnected()) addedListingRepository.getAddedUserTodos(
                PreferenceHelper(context).getString(Constants.USER_TOKEN, ""),
                PreferenceHelper(context).getString(Constants.USER_ID, "")
            ).let {
                getAddedToDoListData.postValue(it)

            }


        }
    }
}