package com.example.roomdb.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdb.Activity.AdduserActivity
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.GlobalVariables.GlobalVariables
import com.example.roomdb.Model.User
import com.example.roomdb.R

class MyAdapter(var context:Context,var list:MutableList<User>) :RecyclerView.Adapter<MyView>()
{
    var db: DatabaseClass? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var layoutInflater = LayoutInflater.from(parent.getContext())
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        db = Room.databaseBuilder(parent.getContext(),
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        return MyView(view)

    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
       /* holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).email)*/
        holder.txt1.setText(list[position].name.toString())
        holder.txt2.setText(list[position].email.toString())

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.txt1.context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                GlobalVariables.id=list[position].id
                GlobalVariables.name=list[position].name
                GlobalVariables.email=list[position].email

                GlobalVariables.updateFlag = "update"
                var i = Intent(context, AdduserActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(i)



            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                deleteuser(list.get(position).id)
                list.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, list.size)



            })
            alert.show()


        }
    }
    fun deleteuser(id:Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deletedata(user)
        Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
    }

}
class MyView(itemview: View) : RecyclerView.ViewHolder(itemview)
{
    var txt1:TextView
    var txt2:TextView

    init
    {
        txt1 = itemview.findViewById(R.id.txt1)
        txt2 = itemview.findViewById(R.id.txt2)
    }

}