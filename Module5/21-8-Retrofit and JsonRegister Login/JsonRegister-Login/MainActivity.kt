package com.example.jsonregisterlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonregisterlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var fname = binding.edt1.text.toString()
            var lname = binding.edt2.text.toString()
            var email = binding.edt3.text.toString()
            var mobile = binding.edt4.text.toString()
            var pass = binding.edt5.text.toString()

            var stringrequest: StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/register.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
                    //startActivity(Intent(applicationContext,MainActivity2::class.java))

                },Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

                })


            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["firstname"]=fname
                    map["lastname"]=lname
                    map["email"]=email
                    map["mobile"]=mobile
                    map["password"]=pass
                    return map
                }

            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)


        }
        binding.txt1.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}