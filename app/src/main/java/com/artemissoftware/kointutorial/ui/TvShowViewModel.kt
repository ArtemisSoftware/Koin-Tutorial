package com.artemissoftware.kointutorial.ui

import androidx.lifecycle.*
import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.repository.TvShowRepository
import kotlinx.coroutines.launch

class TvShowViewModel constructor(private val repository: TvShowRepository) : ViewModel() {

    private val responseTvShow = MutableLiveData<List<TvShow>>()


    val current: LiveData<List<TvShow>> =
        Transformations.map(responseTvShow) { list -> list?.filter { show -> show.status == "Running" } }

    val popular: LiveData<List<TvShow>> =
        Transformations.map(responseTvShow) { list -> list?.filter { show -> if(show.rating.average != null) {show.rating.average.toDouble() > 8.5 && show.status == "Running"} else false } }

    val upcoming: LiveData<List<TvShow>> =
        Transformations.map(responseTvShow) { list -> list?.filter { show -> show.status == "To Be Determined" } }




    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {

        repository.getTvShows().let { response ->
            responseTvShow.postValue(response.body())
        }
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