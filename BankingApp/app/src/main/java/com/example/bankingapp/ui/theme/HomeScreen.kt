package com.example.bankingapp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(widthDp = 400, heightDp = 800)
@Composable
fun HomeScreen(){
    //screen h and w
    val h= LocalConfiguration.current.screenHeightDp
    val w= LocalConfiguration.current.screenWidthDp
    Scaffold(

        bottomBar = {
            BottomNavBar()
        }
    )
    {padding->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ){
            WalletSection()
            CardSection(h,w)
            Spacer(modifier=Modifier.height(16.dp))
            FinanceSection(w = w)
            CurrencySection()
        }


    }
}