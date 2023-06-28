package com.example.listviewex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context:Context,var list: MutableList<Model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var inflater = LayoutInflater.from(context)//layout inflate
        var view =inflater.inflate(R.layout.design,parent,false)

        var image:ImageView = view.findViewById(R.id.img)
        var txt1:TextView = view.findViewById(R.id.txtname)
        var txt2:TextView = view.findViewById(R.id.txtprice)

        //get
        image.setImageResource(list.get(position).image)
        txt1.setText(list.get(position).name)
        txt2.setText(list.get(position).price)

        return view
    }

}