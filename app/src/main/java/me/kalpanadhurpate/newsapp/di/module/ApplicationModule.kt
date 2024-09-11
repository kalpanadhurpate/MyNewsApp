package me.kalpanadhurpate.newsapp.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.kalpanadhurpate.newsapp.di.ApplicationContext
import me.kalpanadhurpate.newsapp.di.BaseUrl
import me.kalpanadhurpate.newsapp.NewsApplication
import me.kalpanadhurpate.newsapp.data.api.NetworkService
import me.kalpanadhurpate.newsapp.di.data.FileHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: NewsApplication){

    @Singleton
    @Provides
    fun provideFileHelper():FileHelper{
        return FileHelper()
    }
    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }

}