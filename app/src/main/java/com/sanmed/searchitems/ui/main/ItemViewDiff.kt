package com.sanmed.searchitems.ui.main

import androidx.recyclerview.widget.DiffUtil

class ItemViewDiff : DiffUtil.ItemCallback<IItemView?>() {

    override fun areItemsTheSame(oldItem: IItemView, newItem: IItemView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: IItemView, newItem: IItemView): Boolean {
        return oldItem.getName() == newItem.getName()
    }

}