package com.sanmed.searchitems.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.repository.IItemsRepository
import dagger.assisted.Assisted
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mRepository: IItemsRepository
) : ViewModel(), IActionWithObject<IItemView> {

    private val _navigateToItemDetail = MutableLiveData<String>()
    val navigateToItemDetail: LiveData<String>
        get() = _navigateToItemDetail

    val itemsFromSearchResult: LiveData<List<IItemView>>
        get() = mRepository.getItemsFromSearchResult()

    override fun onAction(result: IItemView) {
        _navigateToItemDetail.value = result.getId()
    }

    fun onNavigateToItemDetailCompleted() {
        _navigateToItemDetail.value = ""
    }

}