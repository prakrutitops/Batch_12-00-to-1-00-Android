package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dbHelper = DbHelper(applicationContext)
        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            var m= Model()
            m.name=name
            m.num=num

            var id = dbHelper.insertdata(m)
            Toast.makeText(applicationContext,"Record Inserted "+id,Toast.LENGTH_LONG).show()

        }
        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))


        }
    }
}