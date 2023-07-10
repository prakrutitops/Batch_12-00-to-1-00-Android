package com.example.tablayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.view)
        setupviewpager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)


    }

    private fun setupviewpager()
    {
            var adapter = MyAdapter(supportFragmentManager)
            adapter.myfun("CHAT",ChatFragment())
            adapter.myfun("STATUS",StatusFragment())
            adapter.myfun("CALL",CallFragment())
            viewPager.adapter=adapter


    }
}