package com.example.testalovekil2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.testalovekil2.View.Fragment_Qeydiyyat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            /*
        button.setOnClickListener(View.OnClickListener() {
            fun onClick(view: View) {
                val intent = Intent(this@MainActivity, Fragment_Qeydiyyat::class.java)
                Toast.makeText(
                    this@MainActivity,
                    "Qeydiyyat səhifəsinə keçid edildi",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(intent)
            }

        })

        button1.setOnClickListener(View.OnClickListener {
            fun onClick(view: View){
                Toast.makeText(
                    this@MainActivity,
                    "Giris səhifəsinə keçid edildi",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })


             */

    }
}