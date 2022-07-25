package com.example.testalovekil2.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testalovekil2.R
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_vekil_qeydiyyat_seyfe.*

class VekilQeydiyyatSeyfeFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        checkuser()





        btn_logout.setOnClickListener {
            firebaseAuth.signOut()
            checkuser()
        }
    }

    private fun checkuser() {
        val firebaseUser = firebaseAuth.currentUser
        val phone = firebaseUser?.phoneNumber
        phoneTv.text = phone
    }
    >>>>>>> 2fb3e04d99273b2f2469f693a7d03b92604b704e
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vekil_qeydiyyat_seyfe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        checkuser()
        btn_logout.setOnClickListener {
            firebaseAuth.signOut()
            checkuser()
        }
    }

    private fun checkuser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this.activity, OTPFragment::class.java))

        } else {
            val phone = firebaseUser.phoneNumber
            phonenumber.text = phone

        }
    }

}