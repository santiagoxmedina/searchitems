package com.sanmed.searchitems

import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.repository.IItemsRepository

class MainActivityViewModel(repository:IItemsRepository):ViewModel()  {
    private val mRepository:IItemsRepository = repository

    fun onSearch(query: String?) {
        mRepository.search(query)
    }
}