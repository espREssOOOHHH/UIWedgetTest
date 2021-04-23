package com.example.uiwedgettest

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CommonWidget :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.commonwidgetlayout)

        var mytext=findViewById<EditText>(R.id.editText)
        var imageview=findViewById<ImageView>(R.id.imageView)
        var progressbar:ProgressBar=findViewById(R.id.progressBar)
        var button:Button=findViewById(R.id.button_c)
        var button2:Button=findViewById(R.id.button_ex)
        var button3:Button=findViewById(R.id.button_ee)
        button2.visibility=View.INVISIBLE
        button3.visibility=View.INVISIBLE
        progressbar.visibility=View.INVISIBLE

        button.setOnClickListener {
            var inputText=mytext.text.toString()
            Toast.makeText(this,inputText,Toast.LENGTH_SHORT).show()

            if(imageview.drawable.current.constantState==resources.getDrawable(R.drawable.img_1).constantState)
                imageview.setImageResource(R.drawable.img_2)
            else
                imageview.setImageResource(R.drawable.img_1)

            if(progressbar.visibility== View.VISIBLE)
            {
                progressbar.visibility=View.GONE
                button2.visibility=View.GONE
                button3.visibility=View.GONE
            }
            else
            {
                progressbar.visibility=View.VISIBLE
                button2.visibility=View.VISIBLE
                button3.visibility=View.VISIBLE
            }
        }

        button2.setOnClickListener {
            progressbar.progress=progressbar.progress+10;
        }

        button3.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Warning")
                setMessage("Are you surely to reset the progressbar?")
                setCancelable(false)
                setPositiveButton("OK")
                {
                    dialog,which->progressbar.progress=0
                }
                setNegativeButton("Cancel")
                {
                    dialog,which->

                }
                show()
            }

        }


    }


}