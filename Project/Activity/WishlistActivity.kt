package tops.tech.batchproject_morning.Activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classproject.adapters.WishlistAdapter
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.Model.WishlistModel
import tops.tech.batchproject_morning.R
import tops.tech.batchproject_morning.databinding.ActivityDashboardBinding
import tops.tech.batchproject_morning.databinding.ActivityWishlistBinding

class WishlistActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishlistBinding
    private lateinit var mutableList: MutableList<WishlistModel>
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Setting up ActionBar
        binding.mToolbar.title = "My Wishlist"
        setSupportActionBar(binding.mToolbar)
        binding.mToolbar.setNavigationOnClickListener {
            super.finish()


        }
        setContentView(view)
        // Setting up activity window


        mutableList = ArrayList()
        mAdapter = WishlistAdapter(applicationContext, mutableList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

       //sharedprefrence
        sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
        val mob = sharedPreferences.getString("mob", "")


        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call = apiInterface.wishlistViewData(mob)
        call.enqueue(object : Callback<List<WishlistModel>> {
            override fun onResponse(
                call: Call<List<WishlistModel>>,
                response: Response<List<WishlistModel>>
            ) {
                mutableList = response.body() as MutableList<WishlistModel>
                mAdapter = WishlistAdapter(applicationContext, mutableList)
                //binding.progressIndicator.visibility = View.GONE
                binding.recyclerView.adapter = mAdapter
            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {
                Toast.makeText(this@WishlistActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }


}
