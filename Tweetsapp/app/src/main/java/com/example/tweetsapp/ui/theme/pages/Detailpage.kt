package com.example.tweetsapp.ui.theme.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tweetsapp.ui.theme.Appbar
import com.example.tweetsapp.viewmodels.MyviewModelfortweets

@Preview
@Composable
fun DetailPage() {
//    Log.d("mytag","reached here")
    val objFortweets: MyviewModelfortweets = hiltViewModel()
//    Log.d("mytag","reached 2")
    val tweetList = objFortweets.tweets.collectAsState()
//    Log.d("mytag","reached 3")
//    Log.d("mytag","${tweetList.value}")
    val finalLis = if (tweetList.value.size != 0) {
        tweetList.value[0]
    } else {
        emptyList()
    }

//    Log.d("mytag","${tweetList.value}")

    if (finalLis.size == 0) {
        Scaffold(
            topBar = { Appbar("Tweets") }
        ) { paddingValues ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)

            ) {
                Column(
                    Modifier
                        .fillMaxSize(),
//                        .background(color = Color.Blue),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                    ) {

                    CircularProgressIndicator()
                    Text("Loading...", fontWeight = FontWeight.W300)
                }
            }

        }
    } else {
        Scaffold(
            topBar = { Appbar("Tweets") }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
//            .background(Color.Red)
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp)


                ) {
                    items(finalLis.size) { i ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)

                        ) {
                            Text(
                                style = MaterialTheme.typography.displayMedium,
                                modifier = Modifier.padding(10.dp),
                                text = finalLis[i].content
                            )
                        }
                    }
                }
            }

        }
    }

}