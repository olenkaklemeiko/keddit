package com.newgeneration.kedditbysteps.features.news

import com.newgeneration.kedditbysteps.api.NewsAPI
import com.newgeneration.kedditbysteps.api.NewsRestAPI
import com.newgeneration.kedditbysteps.commons.RedditNews
import com.newgeneration.kedditbysteps.commons.RedditNewsItem
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
                subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val dataResponse = response.body()!!.data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                        item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                    dataResponse.after ?: "",
                    dataResponse.before ?: "",
                    news)
                subscriber.onNext(redditNews)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}