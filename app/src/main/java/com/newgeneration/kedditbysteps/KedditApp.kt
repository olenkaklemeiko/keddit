package com.newgeneration.kedditbysteps

import android.app.Application
import com.newgeneration.kedditbysteps.di.AppModule
import com.newgeneration.kedditbysteps.di.news.DaggerNewsComponent
import com.newgeneration.kedditbysteps.di.news.NewsComponent

class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
            .appModule(AppModule(this))
            //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
            .build()
    }
}