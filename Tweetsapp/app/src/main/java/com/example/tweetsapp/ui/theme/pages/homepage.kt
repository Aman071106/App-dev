package com.example.tweetsapp.ui.theme.pages

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tweetsapp.R
import com.example.tweetsapp.datamanager.Tweets
import com.example.tweetsapp.ui.theme.Appbar
import com.example.tweetsapp.viewmodels.MyViewModelForCateogries
import kotlin.reflect.full.memberProperties

//@Preview
@Composable
fun CateogryPage(navController: NavController) {

    //-------viewmodelobject-------------
    val cateogrieslistObj: MyViewModelForCateogries = hiltViewModel()
    Log.d("mytag","viewmodel created")
    val finalcategoryList = cateogrieslistObj.categories.collectAsState()
    Log.d("mytag","final log")
    val lis = getListfromObj(finalcategoryList.value)


    // Load the Lottie animation
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.bg_animation))
    val progress = animateLottieCompositionAsState(composition.value)
    Scaffold(
        topBar = { Appbar("Cateogries") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
//                .background(color = Color.Gray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
//                    .background(color = Color.Blue)
            ) {
                LottieAnimation(
                    composition = composition.value,
                    progress = { progress.value },
                    modifier = Modifier.fillMaxSize()

                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)


                ) {
                    items(
                        lis.size
                    ) { i ->

                        CategoryCard(170, lis[i].toString(),navController)

                    }
                }
            }
        }

    }
}

//CARD
//@Preview(showBackground = true)
@Composable
fun CategoryCard(h: Int = 200, categor: String = "entertainment",navController: NavController) {
    val category = categor.uppercase()
    //-------------------------------------------------------------------
    //map
    // Map file names to raw resource IDs
    val animationMap = mapOf(
        "GAMES" to R.raw.games_icon,
        "ENTERTAINMENT" to R.raw.entertainment_icon,
        "ANDROID" to R.raw.android_icon

        // Add other file names and resource IDs as needed
    )

    // Get the resource ID from the map-for not having icon of a new cateogry we provide bg animation icon
    val resourceId = animationMap.getOrDefault(category, R.raw.bg_animation)
    //----------------------------------------------------------------------

    val composition_ = rememberLottieComposition(LottieCompositionSpec.RawRes(resourceId))
    val progress_ = animateLottieCompositionAsState(composition_.value)
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(h.dp)
            .clip(RoundedCornerShape(50.dp))
            .border(10.dp, color =MaterialTheme.colorScheme.background, shape = RoundedCornerShape(50.dp))
            .background(
//                color = MaterialTheme.colorScheme.secondary,
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary, // Start color
                        MaterialTheme.colorScheme.secondary
                        // End color

                    )
                )

            )
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .clickable { navController.navigate("detail/${categor.lowercase()}") }


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                category.uppercase(),
                modifier = Modifier
                    .wrapContentWidth()
                    .background(color = MaterialTheme.colorScheme.primary)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Center

            )
            //for gap
            Box(
                Modifier
                    .height(5.dp)
                    .background(color = Color.White)
            ) {}
            LottieAnimation(
                composition = composition_.value,
                progress = { progress_.value },
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(80.dp)
                    .align(Alignment.CenterHorizontally)

            )
        }

    }
}


//convert tweets obj to list
fun getListfromObj(tweets: Tweets): List<Any> {
    return tweets::class.memberProperties
        .map { property ->
            property.name // Get the name of the property
        }

}