package com.sanmed.searchitems.ui.itemdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.repository.IItemsRepository
import com.sanmed.searchitems.ui.main.IItemView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val mRepository: IItemsRepository
) : ViewModel() {

    val itemDetailView: LiveData<IItemDetailView>
        get() = mRepository.getItemsItemDetailView()

    fun onItemId(id: String) {
        mRepository.loadItemDetailView(id)
    }
}