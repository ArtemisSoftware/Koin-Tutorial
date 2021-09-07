package com.artemissoftware.kointutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.kointutorial.R

import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val tvShowViewModel : TvShowViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvShowViewModel.responseTvShow.observe(this, { listTvShows ->



        })
    }
}