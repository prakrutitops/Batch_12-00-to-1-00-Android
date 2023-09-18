package tops.tech.lottieanimationex

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity2 : AppCompatActivity()
{
    lateinit var imageView: ImageView
    lateinit var imageView2: ImageView
    lateinit var animationDrawable: AnimationDrawable

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        imageView = findViewById(R.id.img)
        imageView2 = findViewById(R.id.img2)
        animationDrawable=(imageView2.getBackground() as AnimationDrawable)
        myanimate()

        animationDrawable.start()
    }

    private fun myanimate()
    {
            var animation = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
            imageView.startAnimation(animation)
    }
}