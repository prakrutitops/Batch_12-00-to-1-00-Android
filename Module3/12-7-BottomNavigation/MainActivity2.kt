package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txt1 = findViewById(R.id.txt1)

        var i = intent
        Toast.makeText(applicationContext, "" + i.getIntExtra("data", 100), Toast.LENGTH_LONG)
            .show()
        var pos = i.getIntExtra("data", 100)
        var features = i.getStringExtra("feature")
        var screen = i.getIntExtra("screen",101)

        txt1.setText(features)



     /*   if (pos == 0)
        {

        }

        if (pos == 1)
        {

        }*/


    }
}