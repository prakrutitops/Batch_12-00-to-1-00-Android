package com.example.recyclerviewex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.siyamed.shapeimageview.CircularImageView

class MyAdapter(var context:Context,var list:MutableList<Model>) : RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var layoutinflater = LayoutInflater.from(context)
        var view = layoutinflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.textView.setText(list.get(position).name)
        holder.imageview.setImageResource(list.get(position).image)
    }

    override fun getItemCount(): Int
    {
       return list.size
    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{
    lateinit var imageview:CircularImageView
    lateinit  var textView:TextView

    init
    {
         imageview = itemview.findViewById(R.id.i1)
         textView = itemview.findViewById(R.id.t1)
    }
}