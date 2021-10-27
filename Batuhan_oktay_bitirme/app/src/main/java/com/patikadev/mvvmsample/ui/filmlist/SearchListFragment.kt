package com.patikadev.mvvmsample.ui.filmlist

import android.widget.SearchView
import androidx.lifecycle.lifecycleScope
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.databinding.FragmentMovieListBinding
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieFavAdapter
import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import com.patikadev.mvvmsample.ui.filmlist.model.Fragmentitem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class SearchListFragment : BaseFragment<SearchListViewModel, FragmentMovieListBinding>(),Clicklistener {


    var filteredlist= arrayListOf<String>()
    var addedcitylist= arrayListOf<String>()
    override val mviewModel: SearchListViewModel by viewModel()
    lateinit var adapter : MovieFavAdapter

    override fun getLayoutID() = R.layout.fragment_movie_list

    override fun prepareView() {

    }

    override fun observeLiveData() {
        adapter=MovieFavAdapter(filteredlist, this)
        dataBinding.recyclerView.adapter = adapter

        dataBinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            var timer : Timer = Timer()
            var delay : Long =500

            override fun onQueryTextSubmit(p0: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                timer.cancel()
                timer= Timer()
                timer.schedule(object : TimerTask(){
                    override fun run() {
                        lifecycleScope.launch {
                            withContext(Dispatchers.Main) {
                                getdata(p0)
                            }
                        }
                    }
                },delay)
                return true
            }
        })
    }

    private fun getdata(name : String?) {
        if(name?.length!! >0){
            if (name != null) {
                mviewModel.prepareMovies(name)
            }
            mviewModel?.citiesflow?.observe(this, {
                var char : CharSequence=name as CharSequence

                filteredlist.clear()

                it.forEach {
                    if(it.name.lowercase().contains(char)){
                        filteredlist.add(it.name)
                    }
                }
                  adapter?.notifyDataSetChanged()

            })

        }
        else if (name.length<2) {
                filteredlist.clear()
                adapter?.notifyDataSetChanged()
        }
    }

    override fun onClickk(city: String) {
      if(!addedcitylist.contains(city)) {
          addedcitylist.add(city)
          var viewpagerfragment=   parentFragment as ViewPagerFragment
          mviewModel.getCurrent(city)
          mviewModel?.cityCurrent?.observe(this, {
              val feelslise_c=  it.current.feelslike_c
              val feelslike_f=  it.current.feelslike_f
              val temp_c=  it.current.temp_c
              val temp_f=  it.current.temp_f
              val icon=   it.current.condition.icon
              var text=   it.current.condition.text
              val fragmentitem=Fragmentitem(city,temp_c,temp_f,feelslise_c,feelslike_f,text,icon)
              viewpagerfragment.add(fragmentitem)
          })
      }

    }
}



