package com.patikadev.mvvmsample.ui.filmlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.ui.Adapter.CustomPagerAdapter

import com.patikadev.mvvmsample.ui.filmlist.model.Fragmentitem
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewPagerFragment : Fragment() {


    var fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()
     lateinit var  adapter : CustomPagerAdapter
    val mviewModel: SearchListViewModel by viewModel()
    var isfirtopen : Boolean =true


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
            fragments= ArrayList<Fragment>()
            fragments.add(SearchListFragment())
            getCitiesFromDb()
             isfirtopen  =true



    }

     fun add(fragmentitem: Fragmentitem){
        val fragment = AddFragment.newInstance(fragmentitem.title,
            fragmentitem.temp_c,fragmentitem.temp_f,fragmentitem.feelslike_c,
            fragmentitem.feelslike_f,fragmentitem.text,fragmentitem.icon)
        fragments.add(fragment)
         mviewModel.AddCity(fragmentitem)
        adapter.notifyDataSetChanged()
    }

    fun getCitiesFromDb(){
        mviewModel.getCities()
        mviewModel?.CitiesFromDb?.observe(viewLifecycleOwner, {
            it.forEach {
                fragments.add(AddFragment.newInstance(it.title,it.temp_c,it.temp_f,it.feelslike_c,it.feelslike_f,it.text,it.icon))
            }
            if(isfirtopen){
                adapter = CustomPagerAdapter(childFragmentManager,fragments,titles)
                pagerHasan.adapter = adapter
                isfirtopen=false
            }


        })

    }



}
