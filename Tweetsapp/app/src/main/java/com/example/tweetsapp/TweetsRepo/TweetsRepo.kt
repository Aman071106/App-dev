package com.example.tweetsapp.TweetsRepo

import android.util.Log
import com.example.tweetsapp.datamanager.Tweets
import com.example.tweetsapp.datamanager.item
import com.example.tweetsapp.retrofitsetup.RequestMakerMethods
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


//give a requestMaker(Retrofit) by hilt to a interface obj
class TweetsRepo @Inject constructor(private val requestMakerMethods: RequestMakerMethods) {

    //define stateFlows for project-2(cateogries,tweetsfromcateo)
    //stateflow obsereves changes in state over app and recomposition occurs

    //a)cateo
        //1- we are getting from db to here and want it private so that it can't be changed from outside and doesn't affect from outside

        private val _categories= MutableStateFlow<Tweets>(Tweets(emptyList(), emptyList(), emptyList(),
            emptyList(), emptyList()))
        //now _cateogries is a private val which can be modified inside class only...its _ signifies convention of writing private val but it is made private only be private keyword

        //2-public but read only version of private-because it is not mutablestateflow
        val cateogries:StateFlow<Tweets> get()=_categories         //getter

        suspend fun getCateogriesHere(){    //can have same name also
            Log.d("mytag","viewmodel is calling from repo")
            val response=requestMakerMethods.getCateogries()
            if(response.isSuccessful && response.body()!=null){
                _categories.emit(response.body()!!)                  //put the response in the stateflow and assert it non null
            }
            Log.d("mytag","repo got response ${response.body().toString()}")

    }

    //a)tweets


    private val _tweets= MutableStateFlow<List<List<item>>>(emptyList())
    val tweets:StateFlow<List<List<item>>> get()=_tweets        //getter

    suspend fun getTweets(category:String){    //can have same name also
        Log.d("mytag","fetching 1")
        val response=requestMakerMethods.getTweetsFromCateogry("tweets.$category")
        Log.d("mytag","fetching 2")
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)                  //put the response in the stateflow and assert it non null
        }

    }

}