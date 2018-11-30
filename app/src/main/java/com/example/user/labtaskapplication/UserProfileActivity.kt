package com.example.user.labtaskapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.io.ByteArrayOutputStream

class UserProfileActivity : AppCompatActivity() {

    var INTENT_KEY = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)


        var txtUserProfile = findViewById<TextView>(R.id.txtUserProfile)

        txtUserProfile.text=intent.getStringExtra("SecondActivityText")

        var userChangePro = findViewById<ImageView>(R.id.userChangeProfile)

        userChangePro.setOnClickListener(View.OnClickListener {

//            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent,INTENT_KEY)

            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type ="image/*"
            startActivityForResult(intent,INTENT_KEY)
        })


        editIcon.setOnClickListener(View.OnClickListener {

                txtUserProfile.isEnabled = true
                txtUserProfile.isCursorVisible = false

        })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(data!=null)
        {
            if(requestCode==INTENT_KEY && resultCode== Activity.RESULT_OK) {
                val picUriss: Uri = data.data
                val seletedImag: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, picUriss)
                var my_image_frame = findViewById<ImageView>(R.id.userChangeProfile)
                my_image_frame.setImageBitmap(seletedImag)
            }
            else
            {
                ShowToast("Operation Cancelled")
            }
            
        }
    }



}
