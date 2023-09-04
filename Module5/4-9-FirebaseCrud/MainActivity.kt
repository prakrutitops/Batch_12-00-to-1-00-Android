package com.example.firebasecrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrud.databinding.ActivityMainBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        FirebaseApp.initializeApp(applicationContext)
        setContentView(view)

        //layoutmanager
        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutmanager

        var options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("details"), Model::class.java)
            .build()

         myAdapter = MyAdapter(options)
        binding.recycler.adapter=myAdapter

        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }
    }

    override fun onStart()
    {
        super.onStart()
        myAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }
}