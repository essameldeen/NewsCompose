package com.example.newscompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"On Create Block")
    }
    companion object{
        const val TAG ="ApplicationAppNEWs"
    }
}