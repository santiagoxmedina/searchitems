package com.sanmed.searchitems.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.repository.IItemsRepository
import dagger.assisted.Assisted
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(private  val mRepository: IItemsRepository
): ViewModel() {

    fun getItemsFromSearchResult():LiveData<List<IItemView>> {
        return mRepository.getItemsFromSearchResult()
    }

}