package tops.tech.sensorex

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity2 : AppCompatActivity()
{

    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var adapter:BluetoothAdapter
    lateinit var wifi:WifiManager
    private lateinit var permissionLauncher: ActivityResultLauncher<String>


    private val wifiManager: WifiManager by lazy {
        applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1= findViewById(R.id.btn1)
        btn2= findViewById(R.id.btn2)
        btn3= findViewById(R.id.btn3)
        btn4= findViewById(R.id.btn4)


        permissionLauncher = registerForActivityResult(
            // on below line requesting permission.
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // if permission is already granted we are starting the device hotspot.
                startHotSpot()
            } else {
                // displaying toast message if permissions are not provided.
                Toast.makeText(
                    this,
                    "Please allow the Nearby Wi-Fi Devices permission for this app",
                    Toast.LENGTH_LONG,
                ).show()
            }
        }


        adapter = BluetoothAdapter.getDefaultAdapter()

        btn1.setOnClickListener {

            if(!adapter.isEnabled)
            {
                var i = Intent(ACTION_REQUEST_ENABLE)
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return@setOnClickListener
                }
                startActivityForResult(i, 0)
            }


        }
        btn2.setOnClickListener {

                adapter.disable()

        }
        btn3.setOnClickListener {

            checkPermissions()

        }
        btn4.setOnClickListener {

            wifi.setWifiEnabled(false)
        }
    }

    @SuppressLint("NewApi")
    private fun startHotSpot() {
        // below method is use to start local hotspot.
        wifiManager.startLocalOnlyHotspot(
            object : WifiManager.LocalOnlyHotspotCallback() {
                override fun onStarted(reservation: WifiManager.LocalOnlyHotspotReservation?) {
                    super.onStarted(reservation)
                    // this method is called when hotspot is started.
                    // on below line disabling button and changing status text view.
                    btn3.isEnabled = false
                    Toast.makeText(applicationContext,"Status Local Only Hotspot: STARTED",Toast.LENGTH_LONG).show()
                }

                override fun onFailed(reason: Int) {
                    // this method is called when device fails to start hotspot.
                    super.onFailed(reason)
                    // displaying error toast message on below line.
                    Toast.makeText(
                        applicationContext,
                        "Error Local Only Hotspot: $reason",
                        Toast.LENGTH_SHORT,
                    ).show()
                }

                override fun onStopped() {
                    // below method is called when the app has stopped due to any reason.
                    super.onStopped()
                    btn3.isEnabled = true
                    Toast.makeText(applicationContext,"Status Local Only Hotspot: STOPPED",Toast.LENGTH_LONG).show()
                }
            },
            null,
        )
    }
    @SuppressLint("InlinedApi")
    private fun checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // on below line creating a variable for wifi permission.
            val permission: String = android.Manifest.permission.NEARBY_WIFI_DEVICES
            when {
                // on below line checking weather permissions are granted or not.
                ContextCompat.checkSelfPermission(
                    this, permission,
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // if permission are granted starting hotspot by calling below method.
                    startHotSpot()
                }
                // below method is called when permissions are not granted .
                // below method is use to display prompt message when permissions are not provided.
                shouldShowRequestPermissionRationale(permission) -> {
                    MaterialAlertDialogBuilder(this).setMessage("This app would not work without Nearby Wi-Fi Devices permission. Do you want to give this app the permission?")
                        .setPositiveButton("Yes") { _, _ ->
                            permissionLauncher.launch(permission)
                        }.setNegativeButton("No Thanks") { _, _ ->

                        }.show()
                }
                else -> {
                    // on below line calling method to request permissions.
                    permissionLauncher.launch(permission)
                }
            }
        } else {
            // if device is not a android 13 device displaying below toast message.
            Toast.makeText(
                this,
                "Please use Android 13 device.",
                Toast.LENGTH_SHORT,
            ).show()
        }
    }

}