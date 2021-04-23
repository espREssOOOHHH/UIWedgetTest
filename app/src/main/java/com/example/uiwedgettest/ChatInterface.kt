package com.example.uiwedgettest

import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatInterface:AppCompatActivity() , View.OnClickListener{

    private val msgList=ArrayList<Msg>()

    private var adapter:MsgAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.chat1nterface)
        supportActionBar?.hide();
        val backButton:Button=findViewById(R.id.titleBack)
        backButton.setOnClickListener {
            finish()
        }

        initMsg()
        val layoutManager=LinearLayoutManager(this)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerViewForChat)
        recyclerView.layoutManager=layoutManager
        adapter=MsgAdapter(msgList)
        recyclerView.adapter=adapter
        val send=findViewById<Button>(R.id.send)
        send.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        val send:Button=findViewById(R.id.send)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerViewForChat)
        val inputText:EditText=findViewById(R.id.inputText)
        when(v){
            send->{
                val content=inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg=Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size-1)
                    recyclerView.scrollToPosition(msgList.size-1)
                    inputText.setText("")
                }

             }
        }
    }

    private fun initMsg() {

        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}