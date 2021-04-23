package com.example.uiwedgettest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FruitAdapterForRecycler(val fruitList: List<Fruit>):
    RecyclerView.Adapter<FruitAdapterForRecycler.ViewHolder>(){

        inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
            val fruitImage:ImageView=view.findViewById(R.id.fruitImage)
            val fruitName:TextView=view.findViewById(R.id.fruitName)
        }

        override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
            val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.rfruititem,parent,false)
            val viewHolder=ViewHolder(view)
            viewHolder.itemView.setOnClickListener{
                val position=viewHolder.adapterPosition
                val fruit=fruitList[position]
                Log.i("点击事件","点击了文字")
                Toast.makeText(parent.context,"you clicked view \n ${fruit.name}",
                    Toast.LENGTH_SHORT).show()
            }
            viewHolder.fruitImage.setOnClickListener{
                val position=viewHolder.adapterPosition
                val fruit=fruitList[position]
                Log.i("点击事件","点击了图片")
                Toast.makeText(parent.context,"you clicked image \n ${fruit.name}",
                    Toast.LENGTH_SHORT).show()
            }
            return viewHolder
        }

        override fun onBindViewHolder(holder: ViewHolder,position: Int){
            val fruit=fruitList[position]
            holder.fruitImage.setImageResource(fruit.imageId)
            holder.fruitName.text=fruit.name
        }

        override fun getItemCount()=fruitList.size
}