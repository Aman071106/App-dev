package com.example.datamanager

import android.content.Context
import com.example.compose_demo2.R
import com.google.gson.Gson
import kotlinx.coroutines.delay

class DataManager(){
    var data= emptyArray<Quote>()

    fun loadData(context:Context){

        val inputStream=context.assets.open("quotes.json")
        val size:Int= inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8)
        val gson=Gson()
        data=gson.fromJson(json,Array<Quote>::class.java)
    }
}
