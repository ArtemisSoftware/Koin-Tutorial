package com.artemissoftware.kointutorial.api

import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.util.ApiConstants
import retrofit2.Response
import retrofit2.http.GET

interface TvApi {

    companion object {
        const val BASE_URL = "https://api.tvmaze.com/"
    }

    @GET(ApiConstants.END_POINT_SHOWS + "?page=1")
    suspend fun getTvShows(): Response<List<TvShow>>
}