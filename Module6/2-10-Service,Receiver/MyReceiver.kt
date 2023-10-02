package tops.tech.servicereceiverex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent)
    {

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            Toast.makeText(context,"Airplance Mode changed",Toast.LENGTH_LONG).show()
        }

    }
}