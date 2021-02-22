package com.sanmed.searchitems.ui.main

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.sanmed.searchitems.R
import com.sanmed.searchitems.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {


    private val mViewModel by viewModels<MainViewModel>()
    private val mItemViewAdapter = createItemViewAdapter()
    private lateinit var mBinding: MainFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.main_fragment, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initSubscribers()
    }

    private fun initView() {
        mBinding.itemsRecyclerView.adapter = mItemViewAdapter
    }

    private fun initSubscribers() {
        mViewModel.getItemsFromSearchResult().observe(viewLifecycleOwner,this::onSearchResult)
    }

    private fun onSearchResult(items:List<IItemView> ) {
        mItemViewAdapter.submitList(items)
    }

    private fun createItemViewAdapter(): ItemViewAdapter {
        return ItemViewAdapter(ItemViewDiff())
    }


}