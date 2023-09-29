package tops.tech.sensorex

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(),SensorEventListener
{
    lateinit var sensorManager: SensorManager
    lateinit var view:TextView
    var lastUpdate: Long = 0
    private var color = false
    override fun onCreate(savedInstanceState: Bundle?)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        view = findViewById(R.id.txt1)
        view.setBackgroundColor(Color.GREEN)
        lastUpdate = System.currentTimeMillis()


    }

    override fun onSensorChanged(event: SensorEvent?)
    {
        if (event!!.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getAccelerometer(event)
        }
    }

    private fun getAccelerometer(event: SensorEvent)
    {

        val values = event.values
        // Movement
        // Movement
        val x = values[0]
        val y = values[1]
        val z = values[2]

        val accelationSquareRoot = (x * x + y * y + z * z
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH))
        val actualTime = event.timestamp
        if (accelationSquareRoot >= 2) {
            if (actualTime - lastUpdate < 200) {
                return
            }
            lastUpdate = actualTime
            Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT)
                .show()
            if (color)
            {
                view.setBackgroundColor(Color.GREEN)
            } else {
                view.setBackgroundColor(Color.RED)
            }
            color = !color
        }



    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int)
    {

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}