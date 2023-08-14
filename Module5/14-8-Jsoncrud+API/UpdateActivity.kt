package com.example.jsoninsert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoninsert.databinding.ActivityMain2Binding
import com.example.jsoninsert.databinding.ActivityMainBinding
import com.example.jsoninsert.databinding.ActivityUpdate2Binding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdate2Binding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdate2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
      var id =  i.getIntExtra("id",101)
      var name =  i.getStringExtra("name")
      var price =  i.getStringExtra("price")
      var des =  i.getStringExtra("des")

        binding.edt1.setText(name)
        binding.edt2.setText(price)
        binding.edt3.setText(des)

        binding.btn.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()
            var pdes = binding.edt3.text.toString()

            var stringrequest: StringRequest = object : StringRequest(Request.Method.POST,"https://immitigable-weeks.000webhostapp.com/API/update.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))

                }, Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()

                })


            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["id"]= id.toString()
                    map["p_name"]=pname
                    map["p_price"]=pprice
                    map["p_des"]=pdes
                    return map
                }

            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)


        }
    }
}