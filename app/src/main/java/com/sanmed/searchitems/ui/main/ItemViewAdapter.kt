package com.sanmed.searchitems.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanmed.searchitems.R
import com.sanmed.searchitems.databinding.ItemViewBinding

class ItemViewAdapter(diff:ItemViewDiff) : ListAdapter<IItemView?, ItemViewViewHolder>(diff) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewViewHolder {
        val binding = DataBindingUtil.inflate<ItemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_view, parent, false)
        return ItemViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}