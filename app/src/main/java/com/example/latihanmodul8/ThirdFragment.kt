package com.example.latihanmodul8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
class ThirdFragment : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    private var txtName: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mengaplikasikan viewmodel
        communicationViewModel = ViewModelProviders.
        of(requireActivity()).
        get(CommunicationViewModel::class.java)
    }
    //membuat tampilan
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third,
            container, false)
    }
    //mengatur aktivitas setelah tampilan dibuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        //menampilkan data ke textview
        txtName = view.findViewById(R.id.textViewName)
        communicationViewModel!!.name.observe(requireActivity(),
            Observer { s -> txtName!!.text = s })
    }
    //return tampilan fragment
    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }
}