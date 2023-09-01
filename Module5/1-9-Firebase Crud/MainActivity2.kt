package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasecrud.databinding.ActivityMain2Binding
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        FirebaseApp.initializeApp(applicationContext)
        setContentView(view)

        binding.btn1.setOnClickListener {

            var name = binding.edtname.text.toString()
            var email = binding.edtemail.text.toString()
            var num = binding.edtnum.text.toString()

            var map = HashMap<String,String>()
            map["name"]=name
            map["email"]=email
            map["num"]=num

            var db = FirebaseDatabase.getInstance().getReference()
                        .child("details")
                        .push()
                        .setValue(map)
                        .addOnSuccessListener {

                            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                        }
                        .addOnFailureListener {

                            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                        }




        }
    }
}