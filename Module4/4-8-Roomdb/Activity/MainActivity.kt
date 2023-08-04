package com.example.roomdb.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdb.Adapter.MyAdapter
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Model.User
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var db: DatabaseClass
    lateinit var list: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        list = ArrayList()

        var l1: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=l1

        list =  db.daoClass().getUsers()

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=adapter


        binding.f1.setOnClickListener {
            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }

    }
}