package com.artemissoftware.kointutorial.di

import com.artemissoftware.kointutorial.repository.TvShowRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        TvShowRepository(get())
    }
}