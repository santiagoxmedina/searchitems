package com.sanmed.searchitems.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanmed.searchitems.datasource.IRemoteDataSource
import com.sanmed.searchitems.ui.main.IItemView
import javax.inject.Inject

class TestItemRepository @Inject constructor(remoteDataSource:IRemoteDataSource):IItemsRepository {


    private val mRemoteDataSource = remoteDataSource

    override fun search(query: String?) {
        mRemoteDataSource.search(query)
    }

    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return mRemoteDataSource.getItemsFromSearchResult();
    }
}