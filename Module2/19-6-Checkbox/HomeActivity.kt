package com.example.checkboxex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class HomeActivity : AppCompatActivity()
{
    lateinit var c1: CheckBox
    lateinit var c2: CheckBox
    lateinit var c3: CheckBox
    lateinit var btn1: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        c1 = findViewById(R.id.chk1)
        c2 = findViewById(R.id.chk2)
        c3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {

            var builder = StringBuilder("\n Selected Items : \n ")
            var amount =0

            if(c1.isChecked)
            {
                builder.append("\n Pizza @ Rs. 100 \n ")
                amount+=100
            }
            if(c2.isChecked)
            {
                builder.append("\n Burger @ Rs. 70 \n")
                amount+=70
            }
            if(c3.isChecked)
            {
                builder.append("\n Coffee @ Rs. 120 \n")
                amount+=120
            }
            builder.append("--------------------------")
            builder.append("\n Total : "+amount)

            //Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()
            //Log.d("BILL",builder.toString())
            var i = Intent(applicationContext,BillActivity::class.java)
            i.putExtra("BILL",builder.toString())
            startActivity(i)



        }

    }
    override fun onBackPressed()
    {
        finishAffinity()
    }
}