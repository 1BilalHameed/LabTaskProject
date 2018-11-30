package com.example.user.labtaskapplication

import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MyViewHolder(viewItem:View):RecyclerView.ViewHolder(viewItem)
{
    val myItem = viewItem.findViewById<TextView>(R.id.userStatusTxt)
    val myImage =viewItem.findViewById<ImageView>(R.id.userImageView)

}