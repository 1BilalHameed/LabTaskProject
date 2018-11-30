package com.example.user.labtaskapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.items.*
import kotlinx.android.synthetic.main.itemstwo.*
import kotlinx.android.synthetic.main.user_status_layout.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.jar.Manifest

class HomeActivity : AppCompatActivity() {



    var selectImage: Bitmap? = null

    val myList = arrayListOf<DataClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        var userNameFromSecondActivity = findViewById<TextView>(R.id.usertitle)
        //userNameFromSecondActivity.text = intent.getStringExtra("SecondActivityText")


        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = UserCustomAdaptor(myList)

        // adding to recycler view code below

        statusShareBtn.setOnClickListener(View.OnClickListener {

            var userStatus = findViewById<EditText>(R.id.userStatusEd).text.toString()
            myList.add(DataClass(userStatus,selectImage))
            userStatusEd.setText("")
            var myViewBox = findViewById<ImageView>(R.id.my_Image_View)
            myViewBox.setImageBitmap(null)
            val lastPostion = myList.size - 1

            myRecyclerView.adapter?.notifyItemInserted(lastPostion)
            myRecyclerView.scrollToPosition(lastPostion)

        })

        userStatusEd.setOnClickListener(View.OnClickListener {
            userStatusEd.isFocusable = true
            userStatusEd.isFocusableInTouchMode = true
        })

        // sharing image from drawable code below

        val mydrawable: Drawable = timeLineImage2.drawable
        val bitmap: Bitmap = (mydrawable as BitmapDrawable).bitmap
        val bytes = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bytes)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 2)
        }
        val file = File(Environment.getExternalStorageDirectory().toString() + "/Pictures/seminarfree.jpg")
        file.createNewFile()
        val fOut = FileOutputStream(file)

        fOut.write(bytes.toByteArray())
        fOut.flush()
        fOut.close()
        //file.setReadable(true,false

        var share = findViewById<ImageView>(R.id.shareicon2)
        share.setOnClickListener(View.OnClickListener {


            //            val Shareintent = Intent()
//            Shareintent.action = Intent.ACTION_SEND
//            Shareintent.putExtra(Intent.EXTRA_TEXT,"Free Seminar Artifitial Intelligence")
//            Shareintent.type="text/plain"
            // startActivity(Intent.createChooser(Shareintent,"Send to"))

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "https://www.google.com/maps")
            intent.type = "text/plain"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
            intent.type = "image/jpg"
            startActivity(Intent.createChooser(intent, "Share to"))


        })

        var link = findViewById<TextView>(R.id.googleLink)

        link.setOnClickListener(View.OnClickListener {

            var url = Uri.parse("https://www.google.com/maps")
            var intent = Intent(Intent.ACTION_VIEW, url)
            startActivity(intent)
        })


        // selecting image from gallary
        imgGallary.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, INTENT_KEY)
        }

    }


    // above opening gallary and selecting image code part
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (data != null) {
            var photoUri: Uri = data.data

            selectImage = MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            var My_Tv = findViewById<ImageView>(R.id.my_Image_View)
            My_Tv.setImageBitmap(selectImage)
            //myList.add(DataClass())

        }
    }


    override fun onRestart() {
        super.onRestart()
        ShowToast("Welcome Back")
    }

    companion object {
        val INTENT_KEY = 100
    }

    fun getImageUri(inContext: Context, inImage: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)

        val path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null)
        return Uri.parse(path)
    }

}

fun Context.ShowToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}