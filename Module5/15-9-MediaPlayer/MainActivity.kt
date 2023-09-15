package tops.tech.audiovideoex

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var img1:ImageView
    lateinit var img2:ImageView
    lateinit var media:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img1 = findViewById(R.id.i1)
        img2 = findViewById(R.id.i2)
        media = MediaPlayer.create(applicationContext,R.raw.mi_4_mix)

        img1.setOnClickListener {

            media.stop()
            //media.pause()

        }
        img2.setOnClickListener {

            media.start()

        }
    }
}