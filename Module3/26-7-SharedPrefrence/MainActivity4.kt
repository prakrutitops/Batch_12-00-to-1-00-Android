package com.example.myapplication

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity4 : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var t1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(applicationContext)
        t1 = findViewById(R.id.t1)

        val a: String = sharedPreferences.getString("e1", "tops")!!
        val b: String = sharedPreferences.getString("e2", "tops")!!
        val c: Boolean = sharedPreferences.getBoolean("c1", false)
        val d: String = sharedPreferences.getString("list", "tops")!!

        t1.append("\n "+a+" \n ")
        t1.append("\n "+b+" \n ")
        t1.append("\n "+c+" \n ")
        t1.append("\n "+d+" \n ")

    }
}