package tops.tech.advertismentex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity()
{
    lateinit var adView: AdView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adView = findViewById(R.id.adView)

        var adrequest = AdRequest.Builder().build()
        adView.loadAd(adrequest)

    }
}