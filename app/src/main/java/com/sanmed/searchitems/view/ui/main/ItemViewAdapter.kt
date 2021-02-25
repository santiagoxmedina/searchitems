package com.sanmed.searchitems.view.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.sanmed.searchitems.R
import com.sanmed.searchitems.databinding.ItemViewBinding

class ItemViewAdapter(diff:ItemViewDiff,action:IActionWithObject<IItemView>) : ListAdapter<IItemView?, ItemViewViewHolder>(diff) {

    private val mAction = action;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewViewHolder {
        val binding = DataBindingUtil.inflate<ItemViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_view, parent, false)
        binding.action = mAction
        return ItemViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}