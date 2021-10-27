package com.patikadev.mvvmsample.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.patikadev.mvvmsample.R

fun ImageView.downloadImage(url:String?) {
    //if  image to late coming this screen
    try {
        Glide.with(context).load(url!!.castedUrl()).into(this)
    } catch (exeption:Exception) {
        //Exeption
    }
}

fun String.castedUrl(baseUrl: String? = "https:"):String {
    return baseUrl+this
}

@BindingAdapter("android:downloadImage")
fun downloadBindingImage(view: ImageView, url: String?) {
    view.downloadImage(url)
}