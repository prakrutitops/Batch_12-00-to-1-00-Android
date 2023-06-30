package com.example.listviewex

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.listviewex.databinding.ActivityMain2Binding
import com.example.listviewex.databinding.ActivityMain3Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity3 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(CAMERA)!= PERMISSION_GRANTED )
        {
            requestPermissions(arrayOf(CALL_PHONE, CAMERA),101)
        }
        else
        {
            Toast.makeText(applicationContext,"Already Granted",Toast.LENGTH_LONG).show()
        }


        binding.btn1.setOnClickListener {

                var layout = LayoutInflater.from(applicationContext)
                var view = layout.inflate(R.layout.design2,null)
                var alert = AlertDialog.Builder(this)
                alert.setView(view)
                alert.show()

        }

        binding.f1.setOnClickListener {

            Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()

        }
        binding.rate.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            Toast.makeText(applicationContext,""+ratingBar.rating,Toast.LENGTH_LONG).show()
        }
        binding.web.loadUrl("https://www.tops-int.com")




    }


}