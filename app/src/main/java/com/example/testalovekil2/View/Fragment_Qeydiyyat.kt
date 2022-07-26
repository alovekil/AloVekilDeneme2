package com.example.testalovekil2.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.testalovekil2.R
import kotlinx.android.synthetic.main.fragment__qeydiyyat.*
import kotlinx.android.synthetic.main.fragment_register_login.*


class Fragment_Qeydiyyat : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__qeydiyyat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_lawRegister.setOnClickListener {
            val action =  Fragment_QeydiyyatDirections.actionFragmentQeydiyyatToOTPFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btn_clientRegister.setOnClickListener {
            val action = Fragment_QeydiyyatDirections.actionFragmentQeydiyyatToOTPFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}
