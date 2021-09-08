package com.artemissoftware.kointutorial.di

import com.artemissoftware.kointutorial.ui.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        TvShowViewModel(get())
    }
}
