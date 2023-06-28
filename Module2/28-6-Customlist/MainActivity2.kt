package com.example.listviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listviewex.databinding.ActivityMain2Binding
import com.example.listviewex.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list:MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        //set
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))

        var adapter = MyAdapter(applicationContext,list)
        binding.list2.adapter = adapter




    }
}