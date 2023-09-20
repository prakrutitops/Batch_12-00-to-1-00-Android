package tops.tech.customtoastdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView


class MainActivity2 : AppCompatActivity()
{
    lateinit var sliderLayout: SliderLayout
    var map = HashMap<String,String>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sliderLayout = findViewById(R.id.slider)

        map.put("Flower1","https://vyasprakruti.000webhostapp.com/GiftShop/images/img1.jpg")
        map.put("Flower2","https://vyasprakruti.000webhostapp.com/GiftShop/images/img2.jpg")
        map.put("Flower3","https://vyasprakruti.000webhostapp.com/GiftShop/images/img3.jpg")

        for(i in map.keys)
        {
            var txtslider = TextSliderView(this)
            txtslider
                //.description(i)
                .image(map.get(i))

            sliderLayout.addSlider(txtslider)
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage)


    }
}