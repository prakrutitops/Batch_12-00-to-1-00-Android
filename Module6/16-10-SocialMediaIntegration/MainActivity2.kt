package tops.tech.socialmediaintegrationex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton


class MainActivity2 : AppCompatActivity()
{
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(applicationContext)
        //AppEventsLogger.activateApp(this)
        setContentView(R.layout.activity_main2)

        callbackManager = CallbackManager.Factory.create ()
        val loginButton = findViewById<LoginButton>(R.id.login_button)
        loginButton.setReadPermissions("email", "public_profile")
        loginButton.registerCallback(callbackManager,object:FacebookCallback<LoginResult>{

            override fun onSuccess(result: LoginResult?) {
                val accessToken: AccessToken = result!!.getAccessToken()
                //startactivity
               // accessToken.
            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException?) {

            }
        })



    }
}