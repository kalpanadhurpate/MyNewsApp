package me.kalpanadhurpate.newsapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import me.kalpanadhurpate.newsapp.ui.topheadline.TopHeadlineViewModel
import me.kalpanadhurpate.newsapp.data.repository.TopHeadlineRepository
import me.kalpanadhurpate.newsapp.di.ActivityContext
import me.kalpanadhurpate.newsapp.ui.base.ViewModelProviderFactory
import me.kalpanadhurpate.newsapp.ui.topheadline.TopHeadlineAdapter

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsListViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}