package com.patikadev.mvvmsample.util

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


fun Fragment.showToast(messageToShow : String){
    Toast.makeText(requireContext(), messageToShow, Toast.LENGTH_LONG).show()
}

inline fun<reified T : ViewModel> Fragment.getViewModelHolder() : T{

    return ViewModelProvider(this).get(T::class.java)
}


inline fun<reified T : AppCompatActivity> Context.startActivity(block : Intent.() -> Unit = {}){

    val intent  = Intent(this , T::class.java)
    startActivity(
        intent.also {
            block.invoke(it)
        }
    )
}