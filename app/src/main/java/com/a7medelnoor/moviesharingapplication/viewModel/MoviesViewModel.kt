package com.a7medelnoor.moviesharingapplication.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a7medelnoor.moviesharingapplication.model.GridRecyclerViewItem
import com.a7medelnoor.moviesharingapplication.repository.MoviesRepository
import com.a7medelnoor.moviesharingapplication.util.Resources
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.annotation.Resource
import javax.inject.Inject

class MoviesViewModel @ViewModelInject constructor(
    private val repository: MoviesRepository
):ViewModel(){

    private val _gridListItemLiveData = MutableLiveData<Resources<List<GridRecyclerViewItem>>>()
    val gridListItemLiveData: LiveData<Resources<List<GridRecyclerViewItem>>>
    get() = _gridListItemLiveData
    init {
        getGridListItems()
    }

    private fun getGridListItems() = viewModelScope.launch {
     _gridListItemLiveData.postValue(Resources.LOADING)
        val movieDeferred = async { repository.getMovies() }
        val movies = movieDeferred.await()

        val gridItemList = mutableListOf<GridRecyclerViewItem>()
        if (movies is Resources.SUCCESS){
            gridItemList.add(GridRecyclerViewItem.Title(1,"PlayList 1"))
            gridItemList.addAll(movies.value)
            _gridListItemLiveData.postValue(Resources.SUCCESS(gridItemList))
        }else{
             Resources.ERROR(false,null,null)
        }
    }
}

