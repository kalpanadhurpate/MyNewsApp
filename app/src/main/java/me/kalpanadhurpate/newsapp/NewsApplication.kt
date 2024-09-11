package me.kalpanadhurpate.newsapp

import android.app.Application
import me.kalpanadhurpate.newsapp.di.component.ApplicationComponent
import me.kalpanadhurpate.newsapp.di.component.DaggerApplicationComponent
import me.kalpanadhurpate.newsapp.di.data.FileHelper
import me.kalpanadhurpate.newsapp.di.module.ApplicationModule
import javax.inject.Inject

class NewsApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    @Inject
   // lateinit var fileHelper: FileHelper

    override fun onCreate() {
        super.onCreate()
        injectDependencies()

    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}