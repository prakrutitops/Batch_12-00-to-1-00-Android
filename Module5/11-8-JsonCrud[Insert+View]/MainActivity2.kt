package com.example.jsoninsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoninsert.databinding.ActivityMain2Binding
import com.example.jsoninsert.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding

    lateinit var list: MutableList<Model>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringrequest = StringRequest(Request.Method.POST,"https://immitigable-weeks.000webhostapp.com/API/view.php",object :
            Response.Listener<String>{
            override fun onResponse(response: String?)
            {

                var jsonarray = JSONArray(response)
                for(i in 0 until  jsonarray.length())
                {
                    var jsonobject = jsonarray.getJSONObject(i)

                    var p_id = jsonobject.getInt("id")
                    var p_name = jsonobject.getString("p_name")
                    var p_price = jsonobject.getString("p_price")
                    var p_des = jsonobject.getString("p_des")


                    var m = Model()
                    m.id=p_id
                    m.name = p_name
                    m.price=p_price
                    m.des=p_des

                    list.add(m)

                }
                var myadapter = MyAdapter(applicationContext,list)
                binding.list.adapter=myadapter

            }
        },object : Response.ErrorListener{
            override fun onErrorResponse(error: VolleyError?)
            {
                Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
            }
        })
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringrequest)



    }
}