package tops.tech.batchproject_morning.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.squareup.picasso.Picasso
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


    }
}