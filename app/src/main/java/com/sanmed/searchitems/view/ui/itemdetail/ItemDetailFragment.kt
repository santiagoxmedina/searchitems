package com.sanmed.searchitems.view.ui.itemdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sanmed.searchitems.R
import com.sanmed.searchitems.databinding.ItemDetailFragmentBinding
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.viewmodel.itemdetail.ItemDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemDetailFragment : Fragment() {

    private val args by navArgs<ItemDetailFragmentArgs>()
    private val mViewModel by viewModels<ItemDetailViewModel>()
    private lateinit var mBinding: ItemDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_detail_fragment, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.onItemId(args.id)
        mViewModel.itemDetailView.observe(viewLifecycleOwner,this::onItemDetailViewChanged)
    }

    private fun onItemDetailViewChanged(itemDetailView: Resource<IItemDetailView>) {
        if(itemDetailView.data!=null){
            mBinding.itemDetail = itemDetailView.data
            mBinding.executePendingBindings()
        }
    }

}