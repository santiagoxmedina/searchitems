package com.sanmed.searchitems.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.repository.IItemsRepository

class MainViewModel(repository:IItemsRepository) : ViewModel() {
    private val mRepository = repository
    fun getItemsFromSearchResult():LiveData<List<IItemView>> {
        return mRepository.getItemsFromSearchResult()
    }

}