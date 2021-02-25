package com.sanmed.searchitems.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.model.repository.IItemsRepository
import com.sanmed.searchitems.view.ui.main.IActionWithObject
import com.sanmed.searchitems.view.ui.main.IItemView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mRepository: IItemsRepository
) : ViewModel(), IActionWithObject<IItemView> {

    private val _navigateToItemDetail = MutableLiveData<String>()
    val navigateToItemDetail: LiveData<String>
        get() = _navigateToItemDetail

    val itemsFromSearchResult: LiveData<Resource<List<IItemView>>>
        get() = mRepository.getItemsFromSearchResult()

    override fun onAction(result: IItemView) {
        _navigateToItemDetail.value = result.getId()
    }

    fun onNavigateToItemDetailCompleted() {
        _navigateToItemDetail.value = ""
    }

}