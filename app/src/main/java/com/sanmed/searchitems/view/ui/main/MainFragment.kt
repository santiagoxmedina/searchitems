package com.sanmed.searchitems.view.ui.main

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sanmed.searchitems.R
import com.sanmed.searchitems.databinding.MainFragmentBinding
import com.sanmed.searchitems.model.remote.Resource
import com.sanmed.searchitems.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {


    private val mViewModel by viewModels<MainViewModel>()
    private lateinit var mItemViewAdapter:ItemViewAdapter
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
        mItemViewAdapter = createItemViewAdapter()
        mBinding.itemsRecyclerView.adapter = mItemViewAdapter
    }

    private fun initSubscribers() {
        mViewModel.itemsFromSearchResult.observe(viewLifecycleOwner,this::onSearchResult)
        mViewModel.navigateToItemDetail.observe(viewLifecycleOwner,this::onNavigateToItemDetail)
    }

    private fun onSearchResult(items: Resource<List<IItemView>>) {
        if(items.data!=null){
            mItemViewAdapter.submitList(items.data)
        }else{
            mItemViewAdapter.submitList(emptyList())
        }
    }

    private fun onNavigateToItemDetail(id:String ) {
       if(id.isNotEmpty()){
           navigateToItemDetail(id);
           mViewModel.onNavigateToItemDetailCompleted()
       }
    }

    private fun navigateToItemDetail(id: String) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToItemDetailFragment(id))
    }

    private fun createItemViewAdapter(): ItemViewAdapter {
        return ItemViewAdapter(ItemViewDiff(),mViewModel)
    }

}