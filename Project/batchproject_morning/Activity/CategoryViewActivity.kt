package tops.tech.batchproject_morning.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.Adapter.CategoryAdapter
import tops.tech.batchproject_morning.Adapter.DashboardAdapter
import tops.tech.batchproject_morning.LoginActivity
import tops.tech.batchproject_morning.Model.CategoryModel
import tops.tech.batchproject_morning.Model.DashboardModel
import tops.tech.batchproject_morning.R
import tops.tech.batchproject_morning.databinding.ActivityCategoryViewBinding
import tops.tech.batchproject_morning.databinding.ActivityDashboardBinding
import tops.tech.batchproject_morning.databinding.ActivityLoginBinding

class CategoryViewActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityCategoryViewBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<CategoryModel>
    lateinit var call: Call<List<CategoryModel>>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var pos = i.getIntExtra("pos",404)

        var layoutManager:RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager=layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()


        if(pos==0)
        {
             call = apiInterface.fashioncategory_viewdata()
        }
        if(pos==1)
        {
             call = apiInterface.flowercategory_viewdata()
        }
        if(pos==2)
        {
             call = apiInterface.specialcategory_viewdata()
        }





        call.enqueue(object: Callback<List<CategoryModel>>
        {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>)
            {
                list = response.body() as MutableList<CategoryModel>

                var adapter = CategoryAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })
    }


}