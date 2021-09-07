package com.artemissoftware.kointutorial

import android.app.Application
import com.artemissoftware.kointutorial.di.networkModule
import com.artemissoftware.kointutorial.di.repositoryModule
import com.artemissoftware.kointutorial.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}