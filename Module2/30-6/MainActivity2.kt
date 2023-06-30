package com.example.listviewex

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.listviewex.databinding.ActivityMain2Binding

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

    override fun onBackPressed()
    {

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Are you sure you want to exit?")
            alert.setPositiveButton("NO",{
                    dialogInterface: DialogInterface, i: Int ->   dialogInterface.cancel()
            })
            alert.setNegativeButton("YES",{
                    dialogInterface: DialogInterface, i: Int ->  finishAffinity()
            })
            alert.show()
    }
}