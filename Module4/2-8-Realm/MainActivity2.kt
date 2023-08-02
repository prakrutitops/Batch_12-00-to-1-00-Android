package com.example.realmdb

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.realmdb.databinding.ActivityMain2Binding
import io.realm.Realm

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    private lateinit var binding: ActivityMain2Binding
    lateinit var realm: Realm
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        realm = Realm.getInstance(Realm.getDefaultConfiguration())
        list = ArrayList()

        realm.beginTransaction()

        var realmResults = realm.where(Model::class.java).findAll() //select data

        for(i in realmResults.indices)
        {
            list.add(realmResults[i]!!)
        }

        var adpater = MyAdapter(applicationContext,list)
        binding.list.adapter=adpater


        realm.commitTransaction()

        binding.list.setOnItemLongClickListener(this)


    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean
    {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Select Operations?")
        alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->



            var alert2 = AlertDialog.Builder(this)
            var inflater= LayoutInflater.from(this)
            var view =inflater.inflate(R.layout.activity_update,null)

            var edit1: EditText =view.findViewById(R.id.edtname)
            var edit2:EditText =view.findViewById(R.id.edtnum)

            edit1.setText(list.get(position).name)
            edit2.setText(list.get(position).num)

            alert2.setPositiveButton("Edit",{ dialogInterface: DialogInterface, i: Int ->

                realm.beginTransaction()
                var name = edit1.text.toString()
                var num = edit2.text.toString()

                list.get(position).name =name
                list.get(position).num =num
                startActivity(Intent(this,MainActivity2::class.java))
                realm.commitTransaction()
            })
            alert2.setView(view)
            alert2.show()

            /*var i = Intent(applicationContext,UpdateActivity::class.java)
            i.putExtra("id",list.get(position).id)
            i.putExtra("name",list.get(position).name)
            i.putExtra("num",list.get(position).num)
            startActivity(i)*/


        })
        alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()
            realmResults.deleteFromRealm(position)
            realm.commitTransaction()
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        })

        alert.show()


    return false
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}