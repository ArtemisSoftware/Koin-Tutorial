package com.artemissoftware.kointutorial.api.models

data class TvShow(
    val id: Int,
    val image: Image,
    val name: String,

    val rating: TvShowRating,
    val status: String
)

data class TvShowRating(
    val average: String
)