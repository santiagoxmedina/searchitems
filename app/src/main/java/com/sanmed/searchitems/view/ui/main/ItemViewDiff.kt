package com.sanmed.searchitems.view.ui.main

import androidx.recyclerview.widget.DiffUtil

class ItemViewDiff : DiffUtil.ItemCallback<IItemView?>() {

    override fun areItemsTheSame(oldItem: IItemView, newItem: IItemView): Boolean {
        return oldItem.getId() == newItem.getId()
    }

    override fun areContentsTheSame(oldItem: IItemView, newItem: IItemView): Boolean {
        return oldItem.getName() == newItem.getName() && oldItem.getLink() == newItem.getLink()
                && oldItem.getPrice() == newItem.getPrice() && oldItem.getThumbnail() == newItem.getThumbnail()
    }

}