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
import tops.tech.batchproject_morning.Adapter.DashboardAdapter
import tops.tech.batchproject_morning.LoginActivity
import tops.tech.batchproject_morning.Model.DashboardModel
import tops.tech.batchproject_morning.R
import tops.tech.batchproject_morning.databinding.ActivityDashboardBinding
import tops.tech.batchproject_morning.databinding.ActivityLoginBinding

class DashboardActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityDashboardBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<DashboardModel>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""),Toast.LENGTH_LONG).show()

        var layoutManager:RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager=layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()

        var call: Call<List<DashboardModel>> = apiInterface.dashboard_viewdata()
        call.enqueue(object: Callback<List<DashboardModel>>
        {
            override fun onResponse(call: Call<List<DashboardModel>>, response: Response<List<DashboardModel>>)
            {
                list = response.body() as MutableList<DashboardModel>

                var adapter = DashboardAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<DashboardModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })










    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}