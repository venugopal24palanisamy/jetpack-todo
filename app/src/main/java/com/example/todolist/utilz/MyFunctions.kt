package com.example.todolist.utilz

import android.content.Context
import android.util.Log
import com.example.todolist.modal.LoginResponseData
import okhttp3.ResponseBody
import org.json.JSONObject

class MyFunctions {
    companion object {
        fun getApiErrorMessage(errorBody: ResponseBody?) {
            val jsonObject = JSONObject(errorBody.toString())
            val message = jsonObject.getString("message")
            Log.d("getApiErrorMessage", message.toString())
        }

        fun loggedInPreferences(
            context: Context,
            data: LoginResponseData?
        ) {
            PreferenceHelper(context).setBoolean(Constants.IS_LOGGED_IN, true)
            PreferenceHelper(context).setString(Constants.USER_ID, data?.id.toString())
            PreferenceHelper(context).setString(Constants.USER_NAME, data?.username)
            PreferenceHelper(context).setString(Constants.USER_IMAGE, data?.image)
        }
    }
}