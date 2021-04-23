package com.example.uiwedgettest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerView:AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)
        initFruits()
        val layoutManager = StaggeredGridLayoutManager(3,
            StaggeredGridLayoutManager.VERTICAL)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapterForRecycler(fruitList)
        recyclerView.adapter = adapter
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
    private fun initFruits() {
        repeat(5) {
            fruitList.add(Fruit(getRandomLengthString("Apple 🍎"), R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana 🍌"), R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange 🍊"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon 🍉"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear 🍐"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape 🍇"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple 🍍"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Strawberry 🍓"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry 🍒"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango 🥥"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(str:String):String{
        val n=(3..10).random()
        val builder=StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }
}