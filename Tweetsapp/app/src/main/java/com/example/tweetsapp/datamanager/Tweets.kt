package com.example.tweetsapp.datamanager

import kotlin.reflect.full.memberProperties
data class Tweets(
    val android: List<Android>,
    val entertainment: List<Entertainment>,
    val games: List<Game>,
    val health: List<Health>,
    val motivation: List<Motivation>
)





