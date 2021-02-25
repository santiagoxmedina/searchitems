package com.sanmed.searchitems.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanmed.searchitems.repository.IItemsRepository
import dagger.assisted.Assisted
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private  val mRepository: IItemsRepository
):ViewModel()  {


    fun onSearch(query: String?) {
        mRepository.search(query)
    }

//    private fun makeNetworkRequest() {
//        // launch a coroutine in viewModelScope
//        viewModelScope.launch  {
//           // mRepository.slowFetch()
//        }
//    }
}