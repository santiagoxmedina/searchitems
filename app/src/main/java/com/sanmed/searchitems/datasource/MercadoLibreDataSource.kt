package com.sanmed.searchitems.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanmed.searchitems.ItemViewHelper
import com.sanmed.searchitems.conection.RetrofitHelper
import com.sanmed.searchitems.model.MercadoLibreItem
import com.sanmed.searchitems.model.MercadoLibreSearchItemRequest
import com.sanmed.searchitems.model.MercadoLibreSearchItemResponse
import com.sanmed.searchitems.service.MercadoLibreService
import com.sanmed.searchitems.ui.itemdetail.IItemDetailView
import com.sanmed.searchitems.ui.itemdetail.ItemDetailView
import com.sanmed.searchitems.ui.main.IItemView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MercadoLibreDataSource @Inject constructor(): IRemoteDataSource {

    private val resultItems = MutableLiveData<List<IItemView>>()
    private val itemDetail = MutableLiveData<IItemDetailView>()
    private var cacheItems:Array<MercadoLibreItem?> = Array(0){MercadoLibreItem()}

    val retrofit = RetrofitHelper.getRetrofit("https://api.mercadolibre.com/")
    val service = retrofit.create(MercadoLibreService::class.java)


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
            val result = mutableListOf<IItemView>()
            response.body()?.results?.let {
                it.forEach {
                    it?.let { result.add(ItemViewHelper.parseIItemViewFromMercadoLibreItem(it)) }
                }
                cacheItems = it
            }
            resultItems.value = result
        }
    }

    private fun searchRequest(query: String): MercadoLibreSearchItemRequest {
        val request = MercadoLibreSearchItemRequest()
        request.query = query
        request.siteId = "MLA"
        return request
    }


    override fun getItemsFromSearchResult(): LiveData<List<IItemView>> {
        return resultItems
    }

    override fun getItemsItemDetailView(): LiveData<IItemDetailView> {
        return itemDetail
    }

    override fun loadItemDetail(id: String) {
        cacheItems.find { it?.id == id }?.let {
            itemDetail.value = ItemViewHelper.parseIItemDetailViewFromMercadoLibreItem(it)
        }


    }
}