package com.example.tweetsapp.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsapp.TweetsRepo.TweetsRepo
import com.example.tweetsapp.datamanager.item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyviewModelfortweets @Inject constructor(private val repo:TweetsRepo,
    private val savedStateHandle: SavedStateHandle):ViewModel() {
    val tweets: StateFlow<List<List<item>>> get() = repo.tweets

    init{
        viewModelScope.launch {
            Log.d("mytag","trying to initialize")
            repo.getTweets(savedStateHandle.get<String>("category")!!)
            Log.d("mytag","completed")
        }
    }
}