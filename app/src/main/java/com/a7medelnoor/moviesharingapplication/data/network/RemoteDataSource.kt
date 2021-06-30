package com.a7medelnoor.moviesharingapplication.data.network

import com.a7medelnoor.moviesharingapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {
    companion object {
        private const val BASE_URL = "https://60db71d5801dcb0017291156.mockapi.io/"
    }
    fun <MoviesApi> buildApi(
        moviesApi: Class<com.a7medelnoor.moviesharingapplication.data.network.MoviesApi>
    ): com.a7medelnoor.moviesharingapplication.data.network.MoviesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(moviesApi)
    }
    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                }.build())
            }.also { client ->
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build()
    }
}
