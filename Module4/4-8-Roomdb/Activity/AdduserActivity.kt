package com.example.roomdb.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.GlobalVariables.GlobalVariables
import com.example.roomdb.Model.User
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityAdduserBinding
import com.example.roomdb.databinding.ActivityMainBinding

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    lateinit var db: DatabaseClass
    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        if (GlobalVariables.updateFlag.equals("update"))
        {
            edt1.setText(GlobalVariables.name)
            edt2.setText(GlobalVariables.email)
        }

        btn1.setOnClickListener {


            var name = edt1.text.toString()
            var email = edt2.text.toString()

            if(GlobalVariables.updateFlag.equals("update"))
            {

                var u = User()
                u.id=GlobalVariables.id
                u.name=name
                u.email=email

                db!!.daoClass().updatedata(u)
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show();
                GlobalVariables.updateFlag = ""

                startActivity(Intent(applicationContext,MainActivity::class.java))
            }
            else
            {
                var m = User()
                m.name=name
                m.email=email

                db.daoClass().insertdata(m)

                Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }





        }


    }
}