package com.sanmed.searchitems.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.sanmed.searchitems.databinding.ItemViewBinding

class ItemViewViewHolder (binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {


    private val mBinding = binding;


    fun bind(itemView: IItemView?) {
        itemView.let {
            mBinding.itemView = it
            mBinding.executePendingBindings()
        }
    }

}