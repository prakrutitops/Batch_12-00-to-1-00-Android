package com.example.jsonregisterlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonregisterlogin.databinding.ActivityMain2Binding
import com.example.jsonregisterlogin.databinding.ActivityMainBinding
import org.json.JSONException
import java.util.Objects

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            var mobile = binding.edt4.text.toString()
            var pass = binding.edt5.text.toString()

           /* var stringrequest = StringRequest(Request.Method.POST,
                "https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/login.php",
                object : Response.Listener<String> {
                    override fun onResponse(response: String?) {
                        TODO("Not yet implemented")
                    }


                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(error: VolleyError?) {
                        TODO("Not yet implemented")
                    }

                })*/

            var stringrequest:StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/login.php",{
                    response->

                        try
                        {
                            if(response.trim().equals("0"))
                            {
                                Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                            }
                        }
                        catch (e:JSONException)
                        {
                                print(e)
                        }


            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })


            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["mobile"]=mobile
                    map["password"]=pass
                    return map


                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)



        }


    }
}