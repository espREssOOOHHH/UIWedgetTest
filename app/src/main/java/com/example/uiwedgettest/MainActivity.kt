package com.example.uiwedgettest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout)
        var button: Button =findViewById(R.id.button1)
        button.setOnClickListener {
            Toast.makeText(this,"展示常见的控件",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,CommonWidget::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.2 常见控件")
        }

        var button1:Button=findViewById(R.id.button2)
        button1.setOnClickListener {
            Toast.makeText(this,"展示不同的基本布局",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,BasicLayout::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.3 三种基本布局")
        }

        var button2:Button=findViewById(R.id.button3)
        button2.setOnClickListener {
            Toast.makeText(this,"自定义控件",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,CustomViews::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.4 自定义控件")
        }

        var button3:Button=findViewById(R.id.button4)
        button3.setOnClickListener {
            Toast.makeText(this,"最难用和最常用的控件",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,ListView::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.5 ListView简介")
        }

        var button4:Button=findViewById(R.id.button5)
        button4.setOnClickListener {
            Toast.makeText(this,"更强大的滚动控件",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,RecyclerView::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.6 滚动控件 RecyclerView")
        }

        var button5:Button=findViewById(R.id.button6)
        button5.setOnClickListener {
            Toast.makeText(this,"简单的聊天界面",Toast.LENGTH_SHORT).show()
            val intent=Intent(this,ChatInterface::class.java)
            startActivity(intent)
            Log.i("按钮触发","4.7 编写界面的最佳实践 聊天界面")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainpage,menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit->finish()
        }
        return true
    }
}