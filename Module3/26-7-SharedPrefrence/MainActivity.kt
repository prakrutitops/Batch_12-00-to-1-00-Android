package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("mob","")!!.isEmpty())
        {
                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)
                finish()
        }

        binding.btn1.setOnClickListener {

            var mob = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

                var i = Intent(applicationContext,MainActivity2::class.java)
                var editor :SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("USER_SESSION",true)
                editor.putString("mob",mob)
                editor.putString("pass",pass)
                editor.commit()
                startActivity(i)
        }

    }
}