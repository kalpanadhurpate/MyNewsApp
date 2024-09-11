package me.kalpanadhurpate.newsapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import me.kalpanadhurpate.newsapp.data.api.NetworkService
import me.kalpanadhurpate.newsapp.data.model.Article
import me.kalpanadhurpate.newsapp.di.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScope
class TopHeadlineRepository @Inject constructor(private val networkService: NetworkService) {

    fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map {
            it.articles
        }
    }

}