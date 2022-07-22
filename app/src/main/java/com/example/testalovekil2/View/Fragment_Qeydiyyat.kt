package com.example.testalovekil2.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testalovekil2.R
import kotlinx.android.synthetic.main.fragment__qeydiyyat.*


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
        lawyerregistr.setOnClickListener(View.OnClickListener {
            fun onClick(view: View) {
                val intent = Intent(requireContext(),Fragment_Vekil_Qeydiyyat::class.java)
                startActivity(intent)
            }
            })
    }

}