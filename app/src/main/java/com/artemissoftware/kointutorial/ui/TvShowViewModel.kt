package com.artemissoftware.kointutorial.ui

import androidx.lifecycle.*
import com.artemissoftware.kointutorial.api.models.TvShow
import com.artemissoftware.kointutorial.repository.TvShowRepository
import com.artemissoftware.kointutorial.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class TvShowViewModel constructor(private val repository: TvShowRepository) : ViewModel() {

    private val responseTvShow = MutableLiveData<List<TvShow>>()


    val current: LiveData<Resource<List<TvShow>>> =
        Transformations.map(responseTvShow) { list -> Resource.Success(list.filter { show -> show.status == "Running" }) }

    val popular: LiveData<Resource<List<TvShow>>> =
        Transformations.map(responseTvShow) { list -> Resource.Success(list.filter { show -> if(show.rating.average != null) {show.rating.average.toDouble() > 8.5 && show.status == "Running"} else false }) }


    val upcoming: LiveData<Resource<List<TvShow>>> =
        Transformations.map(responseTvShow) { list -> Resource.Success(list.filter { show -> show.status == "To Be Determined" }) }



    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {

        //option 1

        val response = safeApiCall(apiCall = { repository.getTvShows()})

        if(response is Resource.Success){
            responseTvShow.postValue(response.data!!)
        }


        //option 2

//        repository.getTvShows().let { response ->
//            responseTvShow.postValue(response.body())
//        }


        //option 3

//        val response = repository.getTvShows()
//        responseTvShow.postValue(response.body())
    }



    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(body)
                }
            }
            return Resource.Error(Throwable("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            return Resource.Error(e)
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

}

