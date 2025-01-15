package com.example.tweetsapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.TweetsRepo.TweetsRepo
import com.example.tweetsapp.datamanager.Tweets
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModelForCateogries @Inject constructor(private val repo:TweetsRepo):ViewModel() {

    //flow the repo vals into particular viewmodel
    val categories: StateFlow<Tweets> get()=repo.cateogries

    //on init of obj call for first time is required
    init{
        viewModelScope.launch {
            Log.d("mytag","viewmodel is in init block")
            repo.getCateogriesHere()
            Log.d("mytag","viewmodel is in init block at end")
        }
    }


}