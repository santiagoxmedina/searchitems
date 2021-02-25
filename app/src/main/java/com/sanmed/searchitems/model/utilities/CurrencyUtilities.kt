package com.sanmed.searchitems.model.utilities

import java.text.NumberFormat
import java.util.*

class CurrencyUtilities {
    companion object{
        fun getCurrencyFormat(value:Float):String{
            return  NumberFormat.getCurrencyInstance(Locale.getDefault()).format(value);
        }
    }
}