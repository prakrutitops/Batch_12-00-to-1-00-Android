package tops.tech.batchproject_morning.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.R
import tops.tech.batchproject_morning.databinding.ActivityCategoryViewBinding
import tops.tech.batchproject_morning.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding
    private lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        //setSupportActionBar(binding.mToolbar)
        val mob = sharedPreferences.getString("mob", "")
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        val intent = intent
        val image = intent.getStringExtra("image")
        val giftName = intent.getStringExtra("name")
        val giftDesc = intent.getStringExtra("desc")
        val giftPrice = intent.getStringExtra("price")

        Picasso.get().load(image).into(binding.imageView)
        binding.giftName.text = giftName
        binding.giftDesc.text = giftDesc
        binding.giftPrice.text = giftPrice

        binding.wishListButton.setOnClickListener {

            val call = apiInterface.addDataToWishlist(giftName, giftDesc, giftPrice, image, mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to wishlist", Toast.LENGTH_SHORT)
                        .show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Wishlist Failed", Toast.LENGTH_SHORT).show()
                }
            })


        }
        binding.cartButton.setOnClickListener {


            val call = apiInterface.addDataToCart(giftName, giftDesc, giftPrice, image, mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to cart", Toast.LENGTH_SHORT)
                        .show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "cart Failed", Toast.LENGTH_SHORT).show()
                }
            })



        }

    }
}