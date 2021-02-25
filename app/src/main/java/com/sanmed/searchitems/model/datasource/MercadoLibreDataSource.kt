package com.sanmed.searchitems.model.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanmed.searchitems.view.ItemViewHelper
import com.sanmed.searchitems.model.conection.RetrofitHelper
import com.sanmed.searchitems.model.dto.MercadoLibreItemDTO
import com.sanmed.searchitems.model.remote.MercadoLibreSearchItemRequest
import com.sanmed.searchitems.model.remote.MercadoLibreSearchItemResponse
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.model.service.MercadoLibreService
import com.sanmed.searchitems.view.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.view.ui.main.IItemView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MercadoLibreDataSource @Inject constructor(): IRemoteDataSource {

    private val resultItems = MutableLiveData<Resource<List<IItemDetailView>>>()
    private val itemDetail = MutableLiveData<Resource<IItemDetailView>>()
    private var cacheItemDTOS:Array<MercadoLibreItemDTO?> = Array(0){ MercadoLibreItemDTO() }

    private val retrofit = RetrofitHelper.getRetrofit("https://api.mercadolibre.com/")
    private val service: MercadoLibreService = retrofit.create(MercadoLibreService::class.java)


    override fun search(query: String?) {
        query?.let {
            val request = searchRequest(query)
            val call = service.searchItems(request.siteId, request.query)
            call.enqueue(object : Callback<MercadoLibreSearchItemResponse> {
                override fun onResponse(
                    call: Call<MercadoLibreSearchItemResponse>,
                    response: Response<MercadoLibreSearchItemResponse>
                ) {
                    if (response.isSuccessful) {
                        setItems(response)
                    }
                }
                override fun onFailure(call: Call<MercadoLibreSearchItemResponse>, t: Throwable) {

                }
            })
        }
    }

    private fun setItems(response: Response<MercadoLibreSearchItemResponse>) {
        if(response.body()!=null){
            val result = mutableListOf<IItemDetailView>()
            response.body()?.results?.let {
                it.forEach {
                    it?.let { result.add(ItemViewHelper.parseIItemDetailViewFromMercadoLibreItem(it)) }
                }
                cacheItemDTOS = it
            }
            resultItems.value = Resource.success(result)
        }
    }

    private fun searchRequest(query: String): MercadoLibreSearchItemRequest {
        val request = MercadoLibreSearchItemRequest()
        request.query = query
        request.siteId = "MLA"
        return request
    }


    override fun getItemsFromSearchResult(): LiveData<Resource<List<IItemDetailView>>> {
        return resultItems
    }

    override fun getItemsItemDetailView(): LiveData<Resource<IItemDetailView>> {
        return itemDetail
    }

    override fun loadItemDetail(id: String) {
        cacheItemDTOS.find { it?.id == id }?.let {
            itemDetail.value = Resource.success(ItemViewHelper.parseIItemDetailViewFromMercadoLibreItem(it))
        }


    }
}