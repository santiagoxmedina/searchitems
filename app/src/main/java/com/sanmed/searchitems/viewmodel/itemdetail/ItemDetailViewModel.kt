package com.sanmed.searchitems.viewmodel.itemdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.model.repository.IItemsRepository
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val mRepository: IItemsRepository
) : ViewModel() {

    val itemDetailView: LiveData<Resource<IItemDetailView>>
        get() = mRepository.getItemsItemDetailView()

    fun onItemId(id: String) {
        mRepository.loadItemDetailView(id)
    }
}