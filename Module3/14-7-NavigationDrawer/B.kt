package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView


class B : Fragment() {

    lateinit var sliderLayout: SliderLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment


        var view =  inflater.inflate(R.layout.fragment_b, container, false)

        sliderLayout = view.findViewById(R.id.slider)

        val file_maps = HashMap<String, Int>()

        file_maps["Hannibal"] = R.drawable.a
        file_maps["Big Bang Theory"] = R.drawable.abc
        file_maps["House of Cards"] = R.drawable.a
        file_maps["Game of Thrones"] = R.drawable.abc

        for(name in file_maps.keys)
        {
            val textSliderView = TextSliderView(requireActivity())

            textSliderView
                .description(name)
                .image(file_maps.get(name)!!)
            sliderLayout.addSlider(textSliderView)

            sliderLayout.setPresetTransformer(SliderLayout.Transformer.CubeIn)
        }





        return view
    }


}