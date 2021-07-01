package com.a7medelnoor.moviesharingapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.a7medelnoor.moviesharingapplication.util.Constants.Companion.QUERY_NUMBER

class MainViewModel (
    application: Application
        ):AndroidViewModel(application) {
    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()
        queries[QUERY_NUMBER] = "5"
        return queries
    }
}