package com.example.user.labtaskapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var userPro = findViewById<ImageView>(R.id.userPro)
        userPro.setOnClickListener(View.OnClickListener {


            var firstActivityText = intent.getStringExtra("UserName")
            var intent = Intent(this,UserProfileActivity ::class.java)
            intent.putExtra("SecondActivityText",firstActivityText)
            startActivity(intent)
        })

        var homeImage = findViewById<ImageView>(R.id.userHome)
        homeImage.setOnClickListener(View.OnClickListener {

            var firstActivityText = intent.getStringExtra("UserName")
            var intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("SecondActivityText",firstActivityText)
            startActivity(intent)
        })

        chatfragment.setOnClickListener {
            var intent = Intent(this,MyFragActivity::class.java)
            startActivity(intent)
        }
    }

}
