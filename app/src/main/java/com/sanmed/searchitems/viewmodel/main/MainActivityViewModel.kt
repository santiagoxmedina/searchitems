package com.sanmed.searchitems.viewmodel.main

import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.model.repository.IItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private  val mRepository: IItemsRepository
):ViewModel()  {


    fun onSearch(query: String?) {
        mRepository.search(query)
    }
}