package com.a7medelnoor.moviesharingapplication.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.a7medelnoor.moviesharingapplication.model.Movies
import com.a7medelnoor.moviesharingapplication.model.Results
import com.a7medelnoor.moviesharingapplication.repository.MoviesRepository
import com.a7medelnoor.moviesharingapplication.util.NetWorkResult
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MoviesViewModel @ViewModelInject constructor(
    private val repository: MoviesRepository,
    application: Application
):AndroidViewModel(application){
    private  val TAG = "MoviesViewModel"

     val _gridListResponse :MutableLiveData<NetWorkResult<Movies>> = MutableLiveData()
     fun getMovies (queries: Map<String, String>) = viewModelScope.launch{
           getMoviesSafeCall(queries)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private suspend fun getMoviesSafeCall(queries: Map<String, String>) {
          _gridListResponse.value = NetWorkResult.LOADING()
        if (hasInternetConnection()){
            try {
               val response = repository.remoteDataSource.getMovies(queries)
                _gridListResponse.value = handleMoviesResponse(response)

            }catch (e: Exception){
               _gridListResponse.value = NetWorkResult.ERROR(e.toString())
                Log.d(TAG,e.toString())
            }
        }else{
            _gridListResponse.value = NetWorkResult.ERROR("No internet connection")
        }
    }

    private fun handleMoviesResponse(response: Response<Movies>): NetWorkResult<Movies>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetWorkResult.ERROR("Timeout")
            }
            response.code() == 402 -> {
                return NetWorkResult.ERROR("API Key Limited")
            }
            response.body()!!.results.isNullOrEmpty() -> {
                return NetWorkResult.ERROR("Movies Not Found")
            }
            response.isSuccessful -> {
                val moviesResponse = response.body()
                return NetWorkResult.SUCCESS(moviesResponse!!)
            }
            else -> {
                return NetWorkResult.ERROR(response.message())
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false

        }
    }

}

