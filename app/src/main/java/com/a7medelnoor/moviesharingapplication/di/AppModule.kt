package com.a7medelnoor.moviesharingapplication.di

import com.a7medelnoor.moviesharingapplication.data.network.MoviesApi
import com.a7medelnoor.moviesharingapplication.data.network.RemoteDataSource
import com.a7medelnoor.moviesharingapplication.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTargetApi(
        remoteDataSource: RemoteDataSource
    ): MoviesApi {
        return remoteDataSource.buildApi(MoviesApi::class.java)
    }
}