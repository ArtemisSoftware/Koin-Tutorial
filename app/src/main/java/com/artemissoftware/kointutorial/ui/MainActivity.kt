package com.artemissoftware.kointutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.kointutorial.R
import com.artemissoftware.kointutorial.ui.adapters.TvShowAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val tvShowViewModel : TvShowViewModel by viewModel()
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var popularTvShowAdapter: TvShowAdapter
    private lateinit var upcomingTvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupUI()

        tvShowViewModel.current.observe(this, { resource ->
            tvShowAdapter.submitList(resource.data)
        })

        tvShowViewModel.popular.observe(this, { resource ->
            popularTvShowAdapter.submitList(resource.data)
        })

        tvShowViewModel.upcoming.observe(this, { resource ->
            upcomingTvShowAdapter.submitList(resource.data)
        })

    }



    private fun setupUI() {
        tvShowAdapter = TvShowAdapter()

        rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        popularTvShowAdapter = TvShowAdapter()

        rvPopular.apply {
            adapter = popularTvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        upcomingTvShowAdapter = TvShowAdapter()

        rvUpcoming.apply {
            adapter = upcomingTvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
    }


}