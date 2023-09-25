package com.example.todolist.utilz

import android.util.Log
import okhttp3.ResponseBody
import org.json.JSONObject

class MyFunctions {
    companion object {
        fun getApiErrorMessage(errorBody: ResponseBody?) {
            val jsonObject = JSONObject(errorBody.toString())
            val message = jsonObject.getString("message")
            Log.d("getApiErrorMessage",message.toString())
        }
    }
}