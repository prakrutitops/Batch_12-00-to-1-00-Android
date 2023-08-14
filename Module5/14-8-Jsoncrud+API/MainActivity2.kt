package com.example.jsoninsert

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoninsert.databinding.ActivityMain2Binding
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
        registerForContextMenu(binding.list)

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

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1:MenuItem = menu!!.add(0,1,0,"Update")
        var m2:MenuItem = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id =acm.position
        var m = list[id]
        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",m.id)
                i.putExtra("name",m.name)
                i.putExtra("price",m.price)
                i.putExtra("des",m.des)
                startActivity(i)

            }
            2->
            {
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    var stringrequest:StringRequest = object :StringRequest(Request.Method.POST,"https://immitigable-weeks.000webhostapp.com/API/delete.php",
                        Response.Listener {

                            Toast.makeText(applicationContext,"Deleted",Toast.LENGTH_LONG).show()
                            startActivity(Intent(applicationContext,MainActivity2::class.java))

                        },Response.ErrorListener {

                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

                        })


                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String,String>()
                            map["id"]= m.id.toString()
                            return map
                        }

                    }
                    var queue:RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringrequest)


                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alertDialog.show()
            }
        }
        return super.onContextItemSelected(item)
    }
}