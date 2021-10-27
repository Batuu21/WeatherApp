package com.patikadev.mvvmsample.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.mvvmsample.R

import com.patikadev.mvvmsample.databinding.RowFavBinding

import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieFavAdapter(private val weather: List<String>, private val onlick : Clicklistener) : RecyclerView.Adapter<FavFilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavFilmViewHolder {
        return FavFilmViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_fav,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavFilmViewHolder, position: Int) {
        val weather = this.weather[position]
        holder.populate(weather, onlick)


        holder.binding.button.setOnClickListener {
            onlick.onClickk(weather)

        }




    }

    override fun getItemCount() = this.weather.size
}


class FavFilmViewHolder(val binding: RowFavBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(weather: String, onclick : Clicklistener) {
        binding.weather = weather
        binding.onclick=onclick
        binding.executePendingBindings()
    }

}