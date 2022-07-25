package com.example.testalovekil2.View
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.testalovekil2.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_o_t_p.*
import kotlinx.android.synthetic.main.fragment_o_t_p.view.*
import java.util.concurrent.TimeUnit
class OTPFragment : Fragment() {
    private  var forceResendingToken: PhoneAuthProvider.ForceResendingToken?=null
    private var mCallBack:PhoneAuthProvider.OnVerificationStateChangedCallbacks?=null
    private var mVerificationId:String?=null
    private lateinit var progressDialog:ProgressDialog
    private lateinit var firebaseAuth:FirebaseAuth
    private  fun Tag() = "MAIN_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_o_t_p, container, false)

        view.icontelephone.visibility=View.GONE
        view.telnumberlayout.visibility=View.VISIBLE
        view.otplayout.visibility=View.VISIBLE
        firebaseAuth= FirebaseAuth.getInstance()

        progressDialog= ProgressDialog(activity)
        progressDialog.setTitle("text")
        progressDialog.setCanceledOnTouchOutside(false)
        mCallBack=object :PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                Log.d(Tag(),"onverficationcompleted: ")
                signinwithphoneauth(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                progressDialog.dismiss()
                Log.d(Tag(),"onVerficationfailed ${p0}")
                Toast.makeText(activity,"${p0.message}",Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                Log.d(Tag(),"onCodesent:${p0}")
                mVerificationId=p0
                forceResendingToken=p1
                progressDialog.dismiss()
                phoneEt.visibility=View.GONE
                verificationcode.visibility=View.VISIBLE
                Toast.makeText(activity,"Verification Code sent...",Toast.LENGTH_SHORT).show()
                captioncode.text="Please type the verification code we sent to ${phoneEt.text.toString().trim()}"
                super.onCodeSent(p0, p1)
            }


        }

        view.continuebtn.setOnClickListener{
            //input phone number
            val phone=phoneEt.text.toString().trim()
            //validate phone number
            if(TextUtils.isEmpty(phone)){
                Toast.makeText(this.activity,"Please enter your phone number...",Toast.LENGTH_SHORT).show()

            }
            else{
                startphoneverification(phone)
            }
        }

        view.otpresentcode.setOnClickListener {
            val phone=phoneEt.text.toString().trim()
            //validate phone number
            if(TextUtils.isEmpty(phone)){
                Toast.makeText(this.activity,"Please enter your phone number...",Toast.LENGTH_SHORT).show()

            }
            else{
                resendphoneOTPcode(phone,forceResendingToken)
            }
        }

        view.submit_btn.setOnClickListener {
            val phone=phoneEt.text.toString().trim()
            //validate phone number
            if(TextUtils.isEmpty(phone)){
                Toast.makeText(this.activity,"Please enter your phone number...",Toast.LENGTH_SHORT).show()

            }
            else{
                verifyphonenumber(mVerificationId, code = "")
            }
        }

        return view
    }

    private fun startphoneverification(phone: String){
        progressDialog.setMessage("Verifiying Phone Number...")
        progressDialog.show()
        val option=PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(mCallBack!!)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }

    private fun resendphoneOTPcode(phone:String,token:PhoneAuthProvider.ForceResendingToken?){
        progressDialog.setMessage("Resending code")
        progressDialog.show()
        Log.d(Tag(),"ResendVerificationCode ${phone}")

        val option=PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(phone)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(mCallBack!!)
            .setForceResendingToken(token!!)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }

    private fun verifyphonenumber(verification:String?,code:String){
        progressDialog.setMessage("Verifying code...")
        progressDialog.show()
        val credential=PhoneAuthProvider.getCredential(verification!!,code)
        signinwithphoneauth(credential)
    }

    private fun signinwithphoneauth(credential: PhoneAuthCredential) {
        progressDialog.setMessage("Logging in")
        firebaseAuth.signInWithCredential(credential).addOnSuccessListener {
            progressDialog.dismiss()
            val phone= firebaseAuth.currentUser?.phoneNumber
            Toast.makeText(this.activity,"Logged in a ${phone}",Toast.LENGTH_SHORT).show()
            val intent=Intent(this.activity,VekilQeydiyyatSeyfeFragment::class.java)
            startActivity(intent)
        }.addOnFailureListener {e->
            Toast.makeText(this.activity,"${e.message}",Toast.LENGTH_SHORT).show()
        }
    }

}