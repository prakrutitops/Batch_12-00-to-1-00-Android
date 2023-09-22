package tops.tech.retrofitdata

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.FileUtils
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.retrofitdata.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var name: String
    lateinit var email: String
    lateinit var mob: String
    lateinit var pass: String
    lateinit var apiinterface: Apiinterface
    lateinit var filepath: Uri
    lateinit var  bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        binding.img.setOnClickListener {

            var i = Intent()
            i.type = "image/*"
            i.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)
        }



        binding.btnRegi.setOnClickListener {

            var name = binding.name.text.toString()
            var mobile = binding.mobile.text.toString()
            var email = binding.email.text.toString()
            var pass = binding.pass.text.toString()


           // val name1: RequestBody = create(MultipartBody.FORM,name)
            val name1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,name)
            val mobile1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,mobile)
            val email1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,email)
            val pass1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,pass)

            //val body = MultipartBody.Part.createFormData("img", file.getName(), requestFile)
            var file = getPath(filepath)!!

            // create RequestBody instance from file

            // create RequestBody instance from file
            val requestFile: RequestBody = RequestBody.Companion.create(
                contentResolver.getType(filepath)!!.toMediaTypeOrNull(), file)
            val body = MultipartBody.Part.createFormData("img","xyz",requestFile)


            var call: Call<ResponseBody> = apiinterface.uploaddata(name1,mobile1,email1,pass1,body)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    Toast.makeText(applicationContext,"Success "+body,Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()

                }

            })


        }
    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
                filepath = data.data!!
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
                binding.img.setImageBitmap(bitmap)
            }
            super.onActivityResult(requestCode, resultCode, data)
        }

        @SuppressLint("Range")
        fun getPath(uri: Uri?): String?
        {
            var path=""
            var cursor = contentResolver.query(uri!!, null, null, null, null)
            cursor!!.moveToFirst()
            var document_id = cursor.getString(0)
            document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
            cursor.close()
            cursor = contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null
            )
            if(cursor != null && cursor.moveToFirst() )
            {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
                cursor.close()
            }

            return path
        }

    }

