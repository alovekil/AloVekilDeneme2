package com.example.testalovekil2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.testalovekil2.View.Fragment_Qeydiyyat_Ekrani
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var button1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


 /*           val fragmentQeydiyyat=Fragment_Qeydiyyat_Ekrani()
            val fragment:Fragment?=null
            supportFragmentManager.findFragmentByTag(Fragment_Qeydiyyat_Ekrani::class.java.simpleName)
            if(fragment !is Fragment_Qeydiyyat_Ekrani) {
                supportFragmentManager.beginTransaction().add(
                    R.id.framelayout,
                    fragmentQeydiyyat,
                    Fragment_Qeydiyyat_Ekrani::class.java.simpleName
                ).commit()
            }
            button.visibility=View.GONE*/



        /*val view=inflater.inflate(R.layout.fragment__qeydiyyat, container, false)
         val nxt_btn:Button=view.findViewById(R.id.lawyerregistr)
         nxt_btn.setOnClickListener(){
             val fragment=Fragment_Vekil_Qeydiyyat()
             val transaction=fragmentManager?.beginTransaction()
             transaction?.replace(R.id.layoutvekil,fragment)?.commit()
         }
         return view*/

    }
    fun registeraction(view: View){
       val fragment=Fragment_Qeydiyyat_Ekrani()
        val fragmentransaction=supportFragmentManager.beginTransaction()
        fragmentransaction.replace(R.id.framelayout,fragment).commit()
/*        val intent=Intent(this@MainActivity,Fragment_Qeydiyyat_Ekrani::class.java)
        startActivity(intent)*/

    }
    }