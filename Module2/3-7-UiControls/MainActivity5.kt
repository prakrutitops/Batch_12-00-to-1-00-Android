package com.example.listviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewex.databinding.ActivityMain4Binding
import com.example.listviewex.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain5Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}