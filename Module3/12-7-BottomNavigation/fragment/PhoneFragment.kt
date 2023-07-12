package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.myapplication.fragment.Adapter.MyAdapter
import com.example.myapplication.Model.Model
import com.example.myapplication.R

class PhoneFragment : Fragment() {

    lateinit var listview:GridView
    lateinit var list:MutableList<Model>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_phone, container, false)

        listview = view.findViewById(R.id.list2)
        list = ArrayList()

        //set
        list.add(Model(R.drawable.android,"Android","1234","",0))
       /* list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))*/

        var adapter = MyAdapter(requireActivity(),list)
        listview.adapter = adapter





        return view
    }


}