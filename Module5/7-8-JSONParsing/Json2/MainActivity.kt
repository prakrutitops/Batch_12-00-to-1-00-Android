package com.example.cricket

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
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.list)
        list = ArrayList()

        var stringrequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/cricket.php",object :
            Response.Listener<String>{
            override fun onResponse(response: String?)
            {

                var jsonarray = JSONArray(response)
                for(i in 0 until  jsonarray.length())
                {
                    var jsonobject = jsonarray.getJSONObject(i)

                    var p_id = jsonobject.getString("name")
                    var p_name = jsonobject.getString("surname")
                    var p_price = jsonobject.getString("highest_score")
                    var p_image = jsonobject.getString("image")

                    var m = Model()
                    m.name = p_id
                    m.surname=p_name
                    m.highscore=p_price
                    m.image = p_image

                    list.add(m)

                }
                var myadapter = MyAdapter(applicationContext,list)
                listView.adapter=myadapter

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