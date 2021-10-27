package com.patikadev.mvvmsample.ui.filmlist

import androidx.navigation.fragment.findNavController
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.databinding.FragmentDetailBinding
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment  : BaseFragment<SearchListViewModel,FragmentDetailBinding>() {


    override val mviewModel: SearchListViewModel by viewModel()
    override fun getLayoutID(): Int = R.layout.fragment_detail


    override fun observeLiveData() {
        mviewModel?.cityDetail?.observe(this, {

           val list= it.forecast.forecastday[0].cityHours
            dataBinding.recyclerView.adapter = MovieListAdapter(list)
        })
        dataBinding.detailbuton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToViewPagerFragment())
        }
    }
    override fun prepareView() {
        var args = DetailFragmentArgs.fromBundle(requireArguments())
        dataBinding.title.text=args.name
        mviewModel.getDetail(args.name)



    }

}