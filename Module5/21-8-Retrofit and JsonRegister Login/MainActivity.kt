package com.example.retrofitex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        binding.btn1.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()
            var pdes = binding.edt3.text.toString()

        var call: Call<Void> = apiinterface.insertdata(pname,pprice,pdes)
        call.enqueue(object:Callback<Void>
        {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext,MainActivity2::class.java))
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {

                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

            }
        })

        }

    }
}