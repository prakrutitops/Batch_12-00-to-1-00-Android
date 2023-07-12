package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.myapplication.MainActivity2
import com.example.myapplication.fragment.Adapter.MyAdapter
import com.example.myapplication.Model.Model
import com.example.myapplication.R

class TVFragment : Fragment(), AdapterView.OnItemClickListener {

    lateinit var listview:GridView
    lateinit var list:MutableList<Model>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_t_v, container, false)

        listview = view.findViewById(R.id.list2)
        list = ArrayList()

        //set
        list.add(Model(R.drawable.baseline_tv_24,"simple tV","$100","xyz",25))
        list.add(Model(R.drawable.baseline_screen_search_desktop_24,"thodik smart TV","$250","abc",30))
        list.add(Model(R.drawable.monitor_24,"TV jevu","$56","xyz",25))
        list.add(Model(R.drawable.baseline_tv_24,"simple tV","$100","abc",30))
        /*list.add(Model(R.drawable.baseline_screen_search_desktop_24,"thodik smart TV","$250"))
        list.add(Model(R.drawable.monitor_24,"TV jevu","$56"))
        list.add(Model(R.drawable.baseline_tv_24,"simple tV","$100"))
        list.add(Model(R.drawable.baseline_screen_search_desktop_24,"thodik smart TV","$250"))
        list.add(Model(R.drawable.monitor_24,"TV jevu","$56"))*/


        var adapter = MyAdapter(requireActivity(),list)
        listview.adapter = adapter


        listview.setOnItemClickListener(this)



        return view
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    {
       // Toast.makeText(requireActivity(),""+position,Toast.LENGTH_LONG).show()

        var i = Intent(requireActivity(),MainActivity2::class.java)
        i.putExtra("data",position)
        i.putExtra("feature",list.get(position).features)
        i.putExtra("screen",list.get(position).screensize)
        startActivity(i)

//        if(position==0)
//        {
//
//        }
//        if(position==1)
//        {
//
//        }


    }


}