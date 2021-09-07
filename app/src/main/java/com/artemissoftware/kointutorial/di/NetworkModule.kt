package com.artemissoftware.kointutorial.di

import com.artemissoftware.kointutorial.BuildConfig
import com.artemissoftware.kointutorial.api.TvApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideTvApi(get()) }
    //single { provideNetworkHelper(androidContext()) }

//    single<ApiHelper> {
//        return@single ApiHelperImpl(get())
//    }
}


private fun provideOkHttpClient(): OkHttpClient {

    return if (BuildConfig.DEBUG) {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(TvApi.BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideTvApi(retrofit: Retrofit): TvApi = retrofit.create(TvApi::class.java)