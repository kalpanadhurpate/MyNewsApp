package me.kalpanadhurpate.newsapp.di.component

import android.content.Context
import dagger.Component
import me.kalpanadhurpate.newsapp.NewsApplication
import me.kalpanadhurpate.newsapp.data.api.NetworkService
import me.kalpanadhurpate.newsapp.di.ApplicationContext
import me.kalpanadhurpate.newsapp.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    // fun getTopHeadlineRepository(): TopHeadlineRepository
}