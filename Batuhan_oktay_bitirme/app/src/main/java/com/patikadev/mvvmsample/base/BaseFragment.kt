package com.patikadev.mvvmsample.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.patikadev.mvvmsample.ui.filmlist.ViewPagerFragment
import com.patikadev.mvvmsample.util.showToast

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment(), FragmentActions {

    abstract val mviewModel: VM
    protected lateinit var dataBinding: DB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)


        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView()
        observeLiveData()




        showToast(shouldCheckInternetConnection().toString())
    }


    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun prepareView()
    override fun shouldCheckInternetConnection() = true



}