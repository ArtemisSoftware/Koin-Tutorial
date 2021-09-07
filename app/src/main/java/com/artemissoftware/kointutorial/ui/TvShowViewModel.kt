package com.artemissoftware.kointutorial.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.repository.TvShowRepository

class TvShowViewModel constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShow>>()

    val responseTvShow: LiveData<List<TvShow>>
        get() = _response

    init {
        getAllTvShows()
    }

//    private fun getAllTvShows() = viewModelScope.launch {
//        repository.getTvShows().let {response ->
//
//            if (response.isSuccessful){
//                _response.postValue(response.body())
//            }else{
//                Log.d("tag", "getAllTvShows Error: ${response.code()}")
//            }
//        }
//    }



}
