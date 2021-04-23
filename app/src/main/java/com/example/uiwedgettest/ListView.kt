package com.example.uiwedgettest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast

class ListView:AppCompatActivity() {

    private val fruitList=ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listviewtest)
        initFruits()
        val adapter=FruitAdapter(this,R.layout.fruit1tem,fruitList)
        val listView:ListView=findViewById(R.id.listView1)
        listView.adapter=adapter
        listView.setOnItemClickListener{_,_,position,_->
            val fruit=fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits(){
        repeat(2){
            fruitList.add(Fruit("Apple 🍎",R.drawable.apple_pic))
            fruitList.add(Fruit("Banana 🍌",R.drawable.banana_pic))
            fruitList.add(Fruit("Orange 🍊",R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon 🍉",R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear 🍐",R.drawable.pear_pic))
            fruitList.add(Fruit("Grape 🍇",R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple 🍍",R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry 🍓",R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry 🍒",R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango 🥥",R.drawable.mango_pic))
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