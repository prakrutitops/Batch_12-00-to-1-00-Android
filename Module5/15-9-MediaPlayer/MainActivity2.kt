package tops.tech.audiovideoex

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity()
{
    lateinit var videoView: VideoView
   /* lateinit var img1: ImageView
    lateinit var img2: ImageView*/
    var url="https://vyasprakruti.000webhostapp.com/API/movie.mp4"
   // lateinit var media:MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       /* img1 = findViewById(R.id.i1)
        img2 = findViewById(R.id.i2)*/
        videoView = findViewById(R.id.video)
       // media = MediaPlayer.create(applicationContext,R.raw.sample)
        try
        {
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            val video: Uri = Uri.parse(url)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(video)
            videoView.start()
        }
        catch (e: Exception)
        {
            // TODO: handle exception
            Toast.makeText(this, "Error connecting", Toast.LENGTH_SHORT).show()
        }
    }
}