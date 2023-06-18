package com.example.formex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //1
    lateinit var  e1:EditText
    lateinit var  e2:EditText
    lateinit var  b1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //2
        e1 = findViewById(R.id.edt1)
        e2 = findViewById(R.id.edt2)
        b1 = findViewById(R.id.btn2)

        //3
        b1.setOnClickListener {

            //validation
            var mob = e1.text.toString()
            var pass = e2.text.toString()

            if(mob.length==0 && pass.length==0)
            {
                e1.setError("Please Enter Mobile Number")
                e2.setError("Please Enter Password")
            }
            else if(mob.length==0)
            {
                e1.setError("Please Enter Mobile Number")
            }
            else if(pass.length==0)
            {
                e2.setError("Please Enter Password")
            }
            else
            {
                if(mob.equals("9275003605") && pass.equals("1234"))
                {
                    Toast.makeText(applicationContext,"Logged in Succesfully",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }
                else
                {
                    Toast.makeText(applicationContext,"Invalid Credentials",Toast.LENGTH_LONG).show()
                }


            }




        }




    }
}