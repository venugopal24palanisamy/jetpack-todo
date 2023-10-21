package com.example.todolist.ui.login

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.R
import com.example.todolist.modal.request.LoginRequestData
import com.example.todolist.modal.response.LoginResponseData
import com.example.todolist.repository.LoginRepository
import com.example.todolist.utilz.NetworkHelper
import com.example.todolist.utilz.Resource
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {

    var loginUserName by mutableStateOf("")
    var loginUserPassword by mutableStateOf("")

    var loginUserNameError by mutableStateOf("")
    var loginUserPasswordError by mutableStateOf("")

    val isPasswordToggled by mutableStateOf(false)
    var isPasswordError by mutableStateOf(false)
    var isUserNameError by mutableStateOf(false)
    var isLoading by mutableStateOf(false)

    private val loginUser = MutableLiveData<Resource<LoginResponseData>>()
    val loginData: LiveData<Resource<LoginResponseData>>
        get() = loginUser

    fun loginCall(
        context: Context,
        loginRequestData: LoginRequestData
    ) {
        viewModelScope.launch {
            loginUser.postValue(Resource.loading(null))
            if (NetworkHelper(context).isNetworkConnected()) loginRepository.loginUser(
                loginRequestData
            ).let {
                    if (it.isSuccessful)
                        loginUser.postValue(Resource.success(it.body()))
                    else loginUser.postValue(
                        Resource.error(
                            it.errorBody().toString(),
                            null
                        )
                    )
                }
            else loginUser.postValue(
                Resource.error(
                    context.getString(R.string.no_internet_connection),
                    null
                )
            )
        }
    }

    fun validate(context: Context): Boolean {
        if (loginUserName.isEmpty()) {
            isUserNameError = true
            loginUserNameError = context.getString(R.string.enter_user_name)
            return false
        } else {
            isUserNameError = false
            loginUserNameError = ""
        }
        if (loginUserPassword.isEmpty()) {
            isPasswordError = true
            loginUserPasswordError = context.getString(R.string.enter_password)
            return false
        } else {
            isPasswordError = false
            loginUserPasswordError = ""
        }
        return true
    }
}