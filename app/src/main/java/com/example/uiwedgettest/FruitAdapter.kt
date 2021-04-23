package com.example.uiwedgettest

import android.app.Activity
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(activity:Activity,val resourceID:Int,data:List<Fruit>)
    :ArrayAdapter<Fruit>(activity,resourceID,data) {

    inner class ViewHolder(val fruitImage:ImageView,val furitName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View= convertView ?: LayoutInflater.from(context).inflate(resourceID,parent,false)
        val viewHolder:ViewHolder
        if(null==convertView)
        {
            val fruitImage:ImageView=view.findViewById(R.id.fruitImage)
            val fruitName:TextView=view.findViewById(R.id.fruitName)
            viewHolder=ViewHolder(fruitImage,fruitName)
            view.tag=viewHolder
        }
        else
        {
            viewHolder=view.tag as ViewHolder
        }

        val fruit=getItem(position)

        if(fruit!=null)
        {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.furitName.text=fruit.name
        }
        return view;
    }
}