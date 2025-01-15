package com.example.tweetsapp.retrofitsetup

import com.example.tweetsapp.datamanager.Tweets
import com.example.tweetsapp.datamanager.item
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface RequestMakerMethods {


    //define all endpoints here- not base url based on what things you fetch from database
    //add suspend for asynchronous call
    //1
    @GET("/v3/b/677a8593acd3cb34a8c47853?meta=false")
    suspend fun getCateogries(): Response<Tweets>                    //since i have no header here dont using it, we will handle to get cateogries programtically

    //2-
    //note any key can be given to header
    //there is one more headers option for constant header -vdo2 cheezy code
    @GET("/v3/b/677a8593acd3cb34a8c47853?meta=false")
    suspend fun getTweetsFromCateogry(@Header("X-JSON-Path") cateogry:String): Response<List<List<item>>>                   //we can use any one of them as same object structure we are getting
}