package com.example.realmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realmdb.databinding.ActivityMainBinding
import com.example.realmdb.databinding.ActivityUpdateBinding
import io.realm.Realm

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       /* realm = Realm.getInstance(Realm.getDefaultConfiguration())
        var i = intent
        var id2 = i.getIntExtra("id",101)
        binding.edtname.setText(i.getStringExtra("name"))
        binding.edtnum.setText(i.getStringExtra("num"))



        binding.btnupdate.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            realm.beginTransaction()

               var m = Model()
                m.id=id2
                m.name=name
                m.num=num


            realm.commitTransaction()
            startactivity()

        }*/
    }
}