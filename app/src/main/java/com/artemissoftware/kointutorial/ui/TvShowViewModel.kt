package com.artemissoftware.kointutorial.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.repository.TvShowRepository
import kotlinx.coroutines.launch

class TvShowViewModel constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShow>>()

    val responseTvShow: LiveData<List<TvShow>>
        get() = _response

    init {
        //--getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {

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

//private fun fetchUsers() {
//    viewModelScope.launch {
//        _users.postValue(Resource.loading(null))
//        if (networkHelper.isNetworkConnected()) {
//            mainRepository.getUsers().let {
//                if (it.isSuccessful) {
//                    _users.postValue(Resource.success(it.body()))
//                } else _users.postValue(Resource.error(it.errorBody().toString(), null))
//            }
//        } else _users.postValue(Resource.error("No internet connection", null))
//    }
//}