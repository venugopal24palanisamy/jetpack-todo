package com.example.todolist.di

import com.example.todolist.utilz.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {
    @Provides
    @ViewModelScoped
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        /*if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .build()
                } else OkHttpClient
                    .Builder()
                    .build()*/

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL).client(
                OkHttpClient
                    .Builder().addInterceptor(loggingInterceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}