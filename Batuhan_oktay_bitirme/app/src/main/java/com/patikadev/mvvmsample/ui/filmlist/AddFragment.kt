package com.patikadev.mvvmsample.ui.filmlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.util.downloadImage
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.row_fav.view.*

class AddFragment : Fragment() {
    private var title = ""
    private var tempc = ""
    private var tempf = ""
    private var feelslikef = ""
    private var feelslikec = ""
    private var text = ""
    private var icon = ""
    protected lateinit var dataBinding: ViewDataBinding

    companion object {
        fun newInstance(title : String, tempc : Double,tempf : Double,feelslikec : Double, feelslikef : Double, text : String, icon : String): AddFragment {
            val fragment = AddFragment()
            val bundle = Bundle()
            bundle.putString("title",title)
            bundle.putString("tempc", tempc.toString())
            bundle.putString("tempf",tempf.toString())
            bundle.putString("feelslikec", feelslikec.toString())
            bundle.putString("feelslikef",feelslikef.toString())
            bundle.putString("text", text)
            bundle.putString("icon",icon)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString("title").toString()
        tempc = arguments?.getString("tempc").toString()
        tempf = arguments?.getString("tempf").toString()
        feelslikec = arguments?.getString("feelslikec").toString()
        feelslikef = arguments?.getString("feelslikef").toString()
        text = arguments?.getString("text").toString()
        icon = arguments?.getString("icon").toString()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.title.text=title
        view.tempc.text=tempc
        view.tempf.text=tempf
        view.feelslikec.text=feelslikec
        view.feelslikef.text=feelslikef
        view.icon.downloadImage(icon)
        view.text.text=text


        view.detailbuton.setOnClickListener {
            findNavController().navigate(ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment(title))
        }
    }
}