package com.example.user.labtaskapplication

import android.graphics.Bitmap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_home.view.*
import kotlinx.android.synthetic.main.user_status_layout.view.*

class UserCustomAdaptor(val data:ArrayList<DataClass>):RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_status_layout,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount():Int = data.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {


        p0.myItem.userStatusTxt.text = data[p1].status
        p0.myImage.setImageBitmap(data[p1].img)


    }

}