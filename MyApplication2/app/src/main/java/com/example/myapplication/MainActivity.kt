package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Mytagaman","Edge to edge enabled")
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val greetingTextview= findViewById<TextView>(R.id.tvhello)
        val inputField=findViewById<EditText>(R.id.lnputname)
        val butt=findViewById<Button>(R.id.subButton)
        val nav1=findViewById<Button>(R.id.nav1)
        var diskName=""
        butt.setOnClickListener {
            diskName = inputField.text.toString()  // Fetch the text entered by the user
            if(diskName.isBlank() || diskName.isEmpty()){
                nav1.visibility= View.INVISIBLE
                val message = ""  // Corrected variable name to 'message'
                greetingTextview.text = message  // Set the TextView to display the message
                Toast.makeText(this@MainActivity ,"Plese enter your name!", Toast.LENGTH_SHORT).show()
            }
            else{
                val message = "You entered $diskName"  // Corrected variable name to 'message'
                greetingTextview.text = message  // Set the TextView to display the message
                nav1.visibility= View.VISIBLE
            }

        }

        nav1.setOnClickListener {
            // Create an intent to navigate to SecondActivity
            val intent1 = Intent(this, SecondActivity::class.java)
            intent1.putExtra("USER",diskName)            //importing some variables from first activity before starting 2nd activity
            startActivity(intent1)
        }


        }

    override fun onStart() {
        super.onStart()
        Log.i("Mytagaman","1 started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Mytagaman","1 re-started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Mytagaman","1 re-sumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Mytagaman","1 paused")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Mytagaman","1 dead")
    }
    override fun onStop(){
        super.onStop()
        Log.i("Mytagaman","1 stopped")
    }

}
