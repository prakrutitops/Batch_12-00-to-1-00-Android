package com.example.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitcrudex.databinding.ActivityMainBinding
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
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        binding.btnRegister.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var mobile = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()


         var call: Call<Void> = apiinterface.register(fname,lname,mobile,email,pass)

        call.enqueue(object :Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                Toast.makeText(applicationContext,"Registration Done",Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
               Toast.makeText(applicationContext,"Registration Fail",Toast.LENGTH_LONG).show()
            }
        })

        }
        binding.btnAlreadyAccount.setOnClickListener {

            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
    }
}