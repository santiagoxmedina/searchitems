package com.sanmed.searchitems.model

import com.google.gson.annotations.SerializedName

class MercadoLibreSearchItemResponse {

    @SerializedName("results")
    var results:Array<MercadoLibreItem?> = Array(0){MercadoLibreItem()}


}