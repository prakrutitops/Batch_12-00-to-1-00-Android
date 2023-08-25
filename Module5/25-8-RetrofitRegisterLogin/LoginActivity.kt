package com.example.retrofitcrudex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitcrudex.databinding.ActivityLoginBinding
import com.example.retrofitcrudex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        binding.btnLogin.setOnClickListener {


            var mobile = binding.edtMobile.text.toString()
            var pass = binding.edtPass.text.toString()


            var call: Call<Model> = apiinterface.logindata(mobile, pass)

            call.enqueue(object :Callback<Model>{
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()

                }
            })

        }
    }
}