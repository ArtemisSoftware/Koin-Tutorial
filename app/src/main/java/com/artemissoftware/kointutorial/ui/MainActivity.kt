package com.artemissoftware.kointutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.kointutorial.R
import com.artemissoftware.kointutorial.ui.adapters.TvShowAdapter
import kotlinx.android.synthetic.main.activity_main.*

import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val tvShowViewModel : TvShowViewModel by viewModel()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupUI()

        tvShowViewModel.responseTvShow.observe(this, { listTvShows ->

            tvShowAdapter.submitList(listTvShows)

        })
    }



    private fun setupUI() {
        tvShowAdapter = TvShowAdapter()

        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }


}