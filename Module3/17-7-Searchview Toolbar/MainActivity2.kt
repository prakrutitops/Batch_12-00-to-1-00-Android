package com.example.toolbarcustomization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        getMenuInflater().inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }
}