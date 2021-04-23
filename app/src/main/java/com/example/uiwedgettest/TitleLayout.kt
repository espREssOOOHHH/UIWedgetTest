package com.example.uiwedgettest

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import java.util.jar.Attributes

class TitleLayout(context: Context, attrs:AttributeSet):LinearLayout(context,attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)
        var titleBack:Button=findViewById(R.id.titleBack)
        var titleEdit:Button=findViewById(R.id.titleEdit)

        titleBack.setOnClickListener {
            val activity=context as Activity
            activity.finish()
        }
        titleEdit.setOnClickListener {
            Toast.makeText(context,"编辑",Toast.LENGTH_LONG).show()
        }
    }
}