package com.example.bmicalculator

import android.media.tv.AdResponse
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var w:EditText
    private lateinit var h:EditText
    private lateinit var bmi:EditText
    private lateinit var response:TextView

    fun NullChecker(weight:String, height: String):Boolean{
        if(weight.isEmpty() || height.isEmpty()){
            return false
        }
        return true
    }
    fun calculateBMI(weight: Double, height: Double): String {
        if (height <= 0 || weight <= 0 ) {
            return "Invalid input. Please enter positive values for weight and height."
        }
        val h=height/100
        val bmi = weight / (h* h)

        return when {
            bmi < 18.5 -> "Underweight (BMI: %.2f)".format(bmi)
            bmi in 18.5..24.9 -> "Normal weight (BMI: %.2f)".format(bmi)
            bmi in 25.0..29.9 -> "Overweight (BMI: %.2f)".format(bmi)
            else -> "Obesity (BMI: %.2f)".format(bmi)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val submitButt=findViewById<Button>(R.id.submit)
        val clrButt=findViewById<Button>(R.id.clearbutt)

        w= findViewById(R.id.weight)
        h=findViewById(R.id.height)
        response=findViewById(R.id.response)
        submitButt.setOnClickListener{
            val wg=w.text.toString()
            val hg=h.text.toString()
            if(NullChecker(wg,hg)){
                val wei=wg.toDouble()
                val hei=hg.toDouble()
                val ans=calculateBMI(wei,hei)
                response.text=ans
            }
            else{
                val message="Null values entered"
                response.text=message
            }
        }

        clrButt.setOnClickListener{
            val message=""
            response.text=message
        }




    }
}