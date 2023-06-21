package com.example.radiobuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class LifecycleEx : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_ex)

        Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()


    }

    override fun onStart()
    {

        Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()
        super.onStart()
    }

    override fun onStop()
    {

        Toast.makeText(applicationContext,"Stopped",Toast.LENGTH_LONG).show()
        super.onStop()
    }

    override fun onDestroy()
    {

        Toast.makeText(applicationContext,"Destroyed",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    override fun onRestart()
    {

        Toast.makeText(applicationContext,"Restarted",Toast.LENGTH_LONG).show()
        super.onRestart()
    }

    override fun onPause()
    {

        Toast.makeText(applicationContext,"Pause",Toast.LENGTH_LONG).show()
        super.onPause()
    }

    override fun onResume()
    {

        Toast.makeText(applicationContext,"Resume",Toast.LENGTH_LONG).show()
        super.onResume()
    }


}