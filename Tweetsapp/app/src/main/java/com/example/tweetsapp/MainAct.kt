package com.example.tweetsapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsapp.TweetsRepo.TweetsRepo
import com.example.tweetsapp.datamanager.Tweets
import com.example.tweetsapp.retrofitsetup.RequestMakerMethods
import com.example.tweetsapp.ui.theme.Appbar
import com.example.tweetsapp.ui.theme.TweetsAppTheme
import com.example.tweetsapp.ui.theme.pages.CategoryCard
import com.example.tweetsapp.ui.theme.pages.CateogryPage
import com.example.tweetsapp.ui.theme.pages.DetailPage
import com.example.tweetsapp.viewmodels.MyViewModelForCateogries
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

@AndroidEntryPoint       //for dagger hilt to know the entry point
class MainAct : ComponentActivity() {

//    /*testing code for backend testing
    @Inject
    lateinit var apiObj: RequestMakerMethods

//     */



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Make the app full-screen and hide system bars permanently
        val decorView = window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        /*testing code continue
        GlobalScope.launch { //because we are using suspend function
            //we are calling the methods of interface but we know we can't create their obj

//            var response=apiObj.getCateogries()
            var response2=apiObj.getTweetsFromCateogry("tweets.motivation")
//            Log.d("mytag",response.body().toString())
            Log.d("mytag",response2.body()!![0].toString())
        }
*/

        /*test
        fun getListfromObj(tweets: Tweets): List<Any> {
            return tweets::class.memberProperties
                .map { property ->
                    property.name // Get the name of the property
                }

        }

        val tweets=Tweets(android = emptyList(), entertainment = emptyList(),games=emptyList(), health = emptyList(), motivation = emptyList())
        Log.d("mytag",getListfromObj(tweets).toString())

         */


        setContent {
            TweetsAppTheme {
                Surface {
                    MyApp()
                }

            }
        }
    }
}

@Composable
fun MyApp(){
    val PgController= rememberNavController()
    NavHost(navController = PgController, startDestination ="Home" ) {
        composable(route = "Home") {
                CateogryPage(PgController)
        }
        composable(route = "detail/{category}", arguments = listOf(
            navArgument("category"){
            type= NavType.StringType
            }
        )) {
            DetailPage()
        }
    }
}


