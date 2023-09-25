package com.example.todolist.utilz

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton



class NetworkHelper constructor(private val context: Context) {
    fun isNetworkConnected(): Boolean {
        val result: Boolean
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        result = when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return result
    }
}