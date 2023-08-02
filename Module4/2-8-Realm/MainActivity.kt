package com.example.realmdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.realmdb.databinding.ActivityMainBinding
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            realm.beginTransaction()

            var m = realm.createObject(Model::class.java) //insert data in model
            m.name=name
            m.num=num

            realm.commitTransaction()

            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()

        }
        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }
    }
}