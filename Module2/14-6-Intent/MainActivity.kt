package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //declaration
    lateinit var t1:TextView
    lateinit var t2:TextView
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization

        t1 = findViewById(R.id.txt1)
        t2 = findViewById(R.id.txt2)
        btn1 = findViewById(R.id.btn1)

        t1.setOnClickListener {


                Toast.makeText(applicationContext,"Done",Toast.LENGTH_LONG).show()

        }

        t2.setOnClickListener {

            //explicit
            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }

        btn1.setOnClickListener {

            //website open
           /* var url="https://www.tops-int.com"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)*/

            //call
            var num="9275003605"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)

        }




    }
}