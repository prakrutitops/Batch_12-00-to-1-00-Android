package com.example.toolbarcustomization

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.toolbarcustomization.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var adapter: ArrayAdapter<*>? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.months_array))
        binding.listView.adapter=adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(applicationContext, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()

        }

        binding.listView.setEmptyView(binding.emptyView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        getMenuInflater().inflate(R.menu.menu1, menu)

        val mSearch: MenuItem = menu!!.findItem(R.id.appSearchBar)
        val mSearchView: SearchView = mSearch.getActionView() as SearchView
        mSearchView.setQueryHint("Search")
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter!!.getFilter().filter(newText)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }
}