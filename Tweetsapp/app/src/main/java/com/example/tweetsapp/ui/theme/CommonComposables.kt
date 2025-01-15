package com.example.tweetsapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


//Appbar designing
@Preview(showBackground = true, widthDp = 340, heightDp = 100)
@Composable
fun Appbar(pagename:String="Page name"){
    Box(modifier = Modifier.background(color=MaterialTheme.colorScheme.primary)
        .fillMaxWidth().fillMaxHeight(0.1f)){
        Text(pagename, fontSize = 24.sp, modifier = Modifier.align(Alignment.Center), style = MaterialTheme.typography.bodyLarge)
    }
}


