package me.kalpanadhurpate.newsapp.data.api

import me.kalpanadhurpate.newsapp.data.model.TopHeadlinesResponse
import me.kalpanadhurpate.newsapp.utils.AppConstant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @Headers("X-Api-Key: $API_KEY")
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): TopHeadlinesResponse

}