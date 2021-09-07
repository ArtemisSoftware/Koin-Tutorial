package com.artemissoftware.kointutorial.repository

import com.artemissoftware.kointutorial.api.TvApi

class TvShowRepository (private val api: TvApi) {

    suspend fun getTvShows() = api.getTvShows()

}