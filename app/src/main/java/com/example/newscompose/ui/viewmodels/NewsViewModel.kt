package com.example.newscompose.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor() : ViewModel() {
    init {
        Log.d(TAG, "init block of NewsViewModel")
    }

    companion object {
        const val TAG = "NewsViewModel"
    }
}