package com.example.listviewex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import com.example.listviewex.databinding.ActivityMain3Binding
import com.example.listviewex.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var city = arrayOf("rajkot","baroda","surat")
    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            binding.pb.incrementProgressBy(1)
            setProgress(100*binding.pb.progress)

        }
        binding.btn2.setOnClickListener {

            binding.pb.incrementProgressBy(-1)
            setProgress(100*binding.pb.progress)

        }
        binding.seek1.setOnSeekBarChangeListener(this)
        binding.seek2.setOnSeekBarChangeListener(this)
        binding.seek3.setOnSeekBarChangeListener(this)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.select_dialog_item,city)
        binding.a1.threshold=1
        binding.a1.setAdapter(adapter)


    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
    {

            var r = binding.seek1.progress
            var g = binding.seek2.progress
            var b = binding.seek3.progress


            binding.img.setBackgroundColor(Color.rgb(r,g,b))

    }

    override fun onStartTrackingTouch(seekBar: SeekBar?)
    {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?)
    {

    }


}