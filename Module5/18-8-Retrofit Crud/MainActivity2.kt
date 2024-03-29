package com.example.retrofitex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitex.databinding.ActivityMain2Binding
import com.example.retrofitex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var apiinterface: Apiinterface
    lateinit var list:MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycle.layoutManager=layoutManager

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        list = ArrayList()

       var call: Call<List<Model>> = apiinterface.getdata()
        call.enqueue(object:Callback<List<Model>>
        {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>)
            {
                list = response.body() as MutableList<Model>

                    var adapter = Myadapter(applicationContext,list)
                binding.recycle.adapter=adapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable)
            {
               Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })



    }
}