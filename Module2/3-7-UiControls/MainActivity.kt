package com.example.listviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.listviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Python")



        //adapter
        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        binding.list.adapter = adapter

        binding.search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

              /*  if(list.contains(query))
                {
                    adapter.filter.filter(query)
                }*/

                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {

                adapter.filter.filter(newText)

                return true
            }
        })


    }
}