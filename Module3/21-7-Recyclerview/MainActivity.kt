package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        //LayoutManager

        /*var layoutmanager:RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.layoutManager=layoutmanager*/

        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutmanager

        list.add(Model(R.drawable.a,"Laptop 1"))
        list.add(Model(R.drawable.abc,"Laptop 2"))
        list.add(Model(R.drawable.photo,"Laptop 3"))


        var myadapter = MyAdapter(applicationContext,list)
        recyclerView.adapter=myadapter

    }
}