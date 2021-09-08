package com.artemissoftware.kointutorial.api

import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.util.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApi {

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

    @GET(ApiConstants.END_POINT_SHOWS)
    suspend fun getTvShows(): Response<List<TvShow>>

    @GET(ApiConstants.END_POINT_SHOWS)
    suspend fun getTvShows(@Query("page") page: String): Response<List<TvShow>>
}