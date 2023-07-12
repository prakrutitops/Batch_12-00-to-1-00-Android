package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import com.example.uicontrols.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add("hello")
        list.add("How are You???")
        list.add("Welcomes to IT")
        list.add("this is a Data")



        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        binding.list.adapter=adapter

        registerForContextMenu(binding.list)

        binding.btn1.setOnClickListener {

             var popupmenu = PopupMenu(applicationContext,binding.btn1)
             popupmenu.menuInflater.inflate(R.menu.popup,popupmenu.menu)
             popupmenu.setOnMenuItemClickListener(this)
             popupmenu.show()


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)//menu inflate

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {

        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"call",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                    var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
                    var id = acm.position
                    Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()

                    if(id==0)
                    {

                    }
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
            R.id.i3->
            {
                Toast.makeText(applicationContext,"called",Toast.LENGTH_LONG).show()
            }

        }
        return false
    }
}