package com.example.user.labtaskapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_frag.*

class MyFragActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_frag)

        myViewPager.adapter = MyFragmentAdaptor(supportFragmentManager, arrayListOf(FragmentOne(),FragmentTwo(),FragmentThree()),
                arrayListOf("Media","Messages","Activity"))
        myTabLayout.setupWithViewPager(myViewPager)
    }
}
