package me.kalpanadhurpate.newsapp.di.component

import dagger.Component
import me.kalpanadhurpate.newsapp.di.module.ActivityModule
import me.kalpanadhurpate.newsapp.di.ActivityScope
import me.kalpanadhurpate.newsapp.ui.topheadline.TopHeadlineActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}