package com.example.compose_demo2

import android.os.Bundle
import android.os.TestLooperManager
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.datamanager.DataManager
import com.example.screens.DisplayUi
import com.example.screens.LoadingScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("mytag","runned 1")
        val dt=DataManager()
        var dtload= mutableStateOf(false)
        lifecycleScope.launch(Dispatchers.IO){
//            delay(3000)                       demo
            try {
                dt.loadData(applicationContext)
                if (dt.data.isNotEmpty()) {
                    Log.d("mytag", "First quote author: ${dt.data[0].author}")
                    dtload.value=true
                } else {
                    Log.d("mytag", "No data found in quotes.json.")
                }
            } catch (e: Exception) {
                Log.e("mytag", "Error loading data: ${e.message}", e)
            }
        }

        setContent{
            val configuration = LocalConfiguration.current
            val h = configuration.screenHeightDp
            Log.d("mytag","runned 2")
            if(dtload.value==true){
                DisplayUi(h,dt)
            }
            else{
                LoadingScreen()
            }

        }

    }
}



