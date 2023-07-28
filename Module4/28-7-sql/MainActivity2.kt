package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    var list: List<Model> = ArrayList()
    var arrayList = ArrayList<HashMap<String, String?>>()
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)
        list = dbHelper.viewdata()

        for(i in list)
        {
            var hm = HashMap<String,String?>()
            hm["NAME"]=i.name
            hm["NUM"]=i.num
            arrayList.add(hm)
        }

        var from = arrayOf("NAME","NUM")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter =SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter=adapter


    }
}