package com.newgeneration.kedditbysteps.di.news

import com.newgeneration.kedditbysteps.api.NewsAPI
import com.newgeneration.kedditbysteps.api.NewsRestAPI
import com.newgeneration.kedditbysteps.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
        return NewsRestAPI(redditApi)
    }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }
}