package com.patikadev.mvvmsample.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.databinding.DetailItemBinding



import com.patikadev.mvvmsample.ui.filmlist.model.response.CityHours
import com.patikadev.mvvmsample.util.downloadImage


class MovieListAdapter(private val cityhours: List<CityHours>) : RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {

        return FilmViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.detail_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val city = this.cityhours[position]
       holder.populate(city)
    }

    override fun getItemCount() = this.cityhours.size
}


class FilmViewHolder(private val binding: DetailItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(city: CityHours) {
       binding.feelslikec.text=city.feelslike_c.toString()
        binding.feelslikef.text=city.feelslike_f.toString()
        binding.tempc.text=city.temp_c.toString()
        binding.tempf.text=city.temp_f.toString()
        binding.icon.downloadImage(city.condition.icon)
        binding.text.text=city.condition.text
        binding.time.text=city.time



        binding.executePendingBindings()
    }

}