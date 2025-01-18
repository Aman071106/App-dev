package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.example.bankingapp.ui.theme.HomeScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingAppTheme {
               SetStatusBarColor(MaterialTheme.colorScheme.background)


                //surface is like scaffold here
                Surface(modifier=Modifier.fillMaxSize(),color=Color.Red) {

                    HomeScreen()
                }
            }
        }
    }
}



@Composable
private  fun SetStatusBarColor(color: Color){
    val systemUiController= rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color=color)
    }
}
