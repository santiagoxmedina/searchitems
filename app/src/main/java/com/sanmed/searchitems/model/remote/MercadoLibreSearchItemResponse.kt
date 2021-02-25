package com.sanmed.searchitems.model.remote

import com.google.gson.annotations.SerializedName
import com.sanmed.searchitems.model.dto.MercadoLibreItemDTO

class MercadoLibreSearchItemResponse {

    @SerializedName("results")
    var results:Array<MercadoLibreItemDTO?> = Array(0){ MercadoLibreItemDTO() }


}