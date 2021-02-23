package com.sanmed.searchitems.ui.main

interface IActionWithObject<T> {

    fun onAction(result:T);
}