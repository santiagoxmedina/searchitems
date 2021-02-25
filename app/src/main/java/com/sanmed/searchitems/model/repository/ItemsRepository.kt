package com.sanmed.searchitems.model.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.sanmed.searchitems.model.datasource.ILocalDataSource
import com.sanmed.searchitems.model.datasource.IRemoteDataSource
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView
import javax.inject.Inject

class ItemsRepository @Inject constructor(
    remoteDataSource: IRemoteDataSource,
    localDataSource: ILocalDataSource
) : IItemsRepository {

    private val mRemoteDataSource = remoteDataSource
    private val mLocalDataSource = localDataSource
    private val mItems = MediatorLiveData<Resource<List<IItemView>>>()
    private val mItemDetail = MediatorLiveData<Resource<IItemDetailView>>()

    init {
        mItems.value = Resource.loading(null)

        mItems.addSource(mLocalDataSource.getItemsFromSearchResult()) { newData ->
            setItemValue(Resource.success(newData))
        }
        mItems.addSource(mRemoteDataSource.getItemsFromSearchResult()) { newData ->
            newData?.data?.let {
                mLocalDataSource.replace(it)
            }

        }

        mItemDetail.value = Resource.loading(null)

        mItemDetail.addSource(mLocalDataSource.getItemsItemDetailView()) { newData ->
            setItemDetailValue(Resource.success(newData))
        }
    }

    @MainThread
    private fun setItemValue(newValue: Resource<List<IItemView>>) {
        if (mItems.value != newValue) {
            mItems.value = newValue
        }
    }

    @MainThread
    private fun setItemDetailValue(newValue: Resource<IItemDetailView>) {
        if (mItemDetail.value != newValue) {
            mItemDetail.value = newValue
        }
    }

    override fun search(query: String?) {
        mRemoteDataSource.search(query)
    }

    override fun getItemsFromSearchResult(): LiveData<Resource<List<IItemView>>> {
        return mItems
    }

    override fun getItemsItemDetailView(): LiveData<Resource<IItemDetailView>> {
        return mItemDetail
    }

    override fun loadItemDetailView(id: String) {
        mLocalDataSource.loadItemDetail(id)
    }
}