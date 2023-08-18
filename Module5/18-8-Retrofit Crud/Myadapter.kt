package com.example.retrofitex

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Myadapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<MyView>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView , position: Int)
    {



        holder.textView.setText(list.get(position).p_name)
        holder.textView2.setText(list.get(position).p_price)
        holder.textView3.setText(list.get(position).p_des)

        var apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)


        holder.itemView.setOnClickListener {

            var alertDialog = AlertDialog.Builder(holder.itemView.context)
            alertDialog.setTitle("Select Operation?")
            alertDialog.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


            })
            alertDialog.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(context,""+list.get(position).id,Toast.LENGTH_LONG).show()
               var call: Call<Model?>? =  apiinterface.deletedata(list.get(position).id)
              /*  var i = Intent(context,MainActivity2::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)*/
                call!!.enqueue(object: Callback<Model?>
                    {
                    override fun onResponse(call: Call<Model?>, response: Response<Model?>) {

                        var i = Intent(context,MainActivity2::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)
                    }

                    override fun onFailure(call: Call<Model?>, t: Throwable) {
                       Toast.makeText(context,"No Internet",Toast.LENGTH_LONG).show()
                    }
                })


            })
            alertDialog.show()

        }

    }
}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
     var textView: TextView = Itemview.findViewById(R.id.txt1)
     var textView2: TextView = Itemview.findViewById(R.id.txt2)
     var textView3: TextView = Itemview.findViewById(R.id.txt3)



}