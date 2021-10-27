package com.patikadev.mvvmsample.ui.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle


import androidx.fragment.app.FragmentPagerAdapter


class CustomPagerAdapter(manager: FragmentManager, val fragments : ArrayList<Fragment>, val titles : ArrayList<String>): FragmentPagerAdapter(manager) {


  //  private val fragments = ArrayList<Fragment>()
  //  private val titles = ArrayList<String>()

    override fun getItem(position: Int) : Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence =titles[position]



    fun removeFragment() {
        if(fragments.size==0)
            return
        fragments.removeAt(fragments.size-1)
        titles.removeAt(titles.size-1)
        notifyDataSetChanged()
    }
}