package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
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

        registerForContextMenu(binding.list)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1:MenuItem = menu!!.add(0,1,0,"Update")
        var m2:MenuItem = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position
        var m:Model= list.get(id)

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",m.id)
                i.putExtra("myname",m.name)
                i.putExtra("mynumber",m.num)
                startActivity(i)

            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                        dbHelper.deletedata(m.id)
                        startActivity(Intent(applicationContext,MainActivity2::class.java))

                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                })
                alert.show()
            }
        }

        return super.onContextItemSelected(item)
    }

}