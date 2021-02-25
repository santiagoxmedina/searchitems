package com.sanmed.searchitems.service

import com.sanmed.searchitems.model.MercadoLibreSearchItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreService {

    @GET("/sites/{siteId}/search")
    fun searchItems(@Path("siteId") sitedId:String, @Query("q") query: String): Call<MercadoLibreSearchItemResponse>
}