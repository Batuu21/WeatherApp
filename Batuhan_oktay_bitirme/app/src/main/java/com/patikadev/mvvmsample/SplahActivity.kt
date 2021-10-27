package com.patikadev.mvvmsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import com.patikadev.mvvmsample.databinding.ActivityMainBinding
import com.patikadev.mvvmsample.databinding.ActivitySplahBinding
import com.patikadev.mvvmsample.util.startActivity
import java.util.*

class SplahActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah)

        val DELAY  :  Long = 3 * 1000

        Timer().schedule(object : TimerTask() {
            override fun run() {

                startActivity<MainActivity>()
            }
        }, DELAY)

    }


}