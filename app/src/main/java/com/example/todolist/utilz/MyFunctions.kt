package com.example.todolist.utilz

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.Color
import com.example.todolist.modal.response.LoginResponseData
import okhttp3.ResponseBody
import org.json.JSONObject
import kotlin.random.Random

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
            PreferenceHelper(context).setString(Constants.USER_NAME, data?.name)
            PreferenceHelper(context).setString(Constants.USER_TOKEN, "Bearer " + data?.token)
            Log.d("loggedInPreferences", data?.token + "")
        }

        fun generateRandomColor(): Color {
            val random = Random
            val red = random.nextFloat()
            val green = random.nextFloat()
            val blue = random.nextFloat()
            return Color(red, green, blue)
        }
    }
}