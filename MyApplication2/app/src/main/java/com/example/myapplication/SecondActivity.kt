package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//        }

        val username=intent.getStringExtra("USER")
        val textv=findViewById<TextView>(R.id.msg_)
        val msg="$username, you will have free acess for one month"
        textv.text=msg

    }

    override fun onStart() {
        super.onStart()
        Log.i("Mytagaman","2 started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Mytagaman","2 re-started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Mytagaman","2 re-sumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Mytagaman","2 paused")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Mytagaman","2 dead")
    }
    override fun onStop(){
        super.onStop()
        Log.i("Mytagaman","2 stopped")
    }
}