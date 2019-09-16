package com.newgeneration.kedditbysteps.di.news

import com.newgeneration.kedditbysteps.di.AppModule
import com.newgeneration.kedditbysteps.di.NetworkModule
import com.newgeneration.kedditbysteps.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AppModule::class, NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}