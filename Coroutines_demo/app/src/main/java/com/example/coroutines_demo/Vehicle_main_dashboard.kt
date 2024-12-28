package com.example.coroutines_demo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

// Font imports
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val TimeFontFamily = FontFamily(
    Font(R.font.time_font)
)
val DateFontFamily = FontFamily(
    Font(R.font.date_font)
)

@Preview(
    name = "Landscape Mode",
    device = "spec:width=640dp,height=480dp,dpi=240",
    showSystemUi = true
)
@Composable
fun Main_Dashboard() {
    // Get the screen width and height
    val W = LocalConfiguration.current.screenWidthDp.dp
    val H = LocalConfiguration.current.screenHeightDp.dp

    // Get current time and date
    val currentTime =
        SimpleDateFormat("hh:mm", Locale.getDefault()).format(Calendar.getInstance().time)
    var currentDate =
        SimpleDateFormat("dd MMMM", Locale.getDefault()).format(Calendar.getInstance().time)
    currentDate = currentDate.toString().toUpperCase()

    Log.d("maintag", "Execution-1 done")

    // Box that takes the full screen and has 0.1% padding
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                (W.value * 0.01).dp,
                (H.value * 0.02).dp,
                (W.value * 0.01).dp,
                (H.value * 0.01).dp
            )
            .background(color = Color(0xFF000000))
    ) {
        //date and time done
        Column(
            modifier = Modifier
                .padding(
                    ((W.value * 0.09).dp), (H.value * 0.05).dp, 0.dp, 0.dp
                )
                .height((H.value * 0.11).dp)
                .width((W.value * 0.16).dp)
        ) {
            // Display current time
            Text(
                text = currentTime,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .weight(0.6f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Thin,
                color = Color(0xFFFFC401) // Yellow
//                ,fontFamily = TimeFontFamily                  //set later due to preview issues
            )

            // Display current date (in dd-Month Name format)
            Text(
                text = currentDate,
                modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth()
                    .weight(0.4f),
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFB77218) // Brown
//                ,fontFamily = DateFontFamily          //set later due to preview issues
            )
        }

        //2-battery bar
        Column(
            modifier = Modifier
                .padding(
                    (W.value * 0.24).dp, (H.value * 0.03).dp, 0.dp, 0.dp
                )
                .height((H.value * 0.32).dp)
                .width((W.value * 0.11).dp), verticalArrangement = Arrangement.SpaceEvenly

        ) {
            Text(
                text = "Battery",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Box(modifier = Modifier.fillMaxSize()) {
                //Battery-To be replaced by original received data, range
                val fetched_batterylevel = remember { mutableFloatStateOf(100f) }
                Battery(fetched_batterylevel.value)
                val totalrange = 500

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = "${fetched_batterylevel.value.toInt()}%\n",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
//                        ,fontFamily = FontFamily(Font(R.font.batteryfont))
                        , fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${(totalrange * fetched_batterylevel.value / 100).toInt()} Km",
                        color = Color.White,
                        fontSize = 10.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
//                        ,fontFamily = FontFamily(Font(R.font.batteryfont))
                    )
                }
            }
        }
        Text(
            text = "Dashboard", color = Color.White, modifier = Modifier
                .padding((0.41 * W.value).dp, (0.045 * H.value).dp, 0.dp, 0.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        //2-Temp vehicle
        Box(
            modifier = Modifier
                .padding((0.38 * W.value).dp, (0.13 * H.value).dp, 0.dp, 0.dp)

        )
        {
            val h = (0.28 * H.value).toInt()
            val w = (0.16 * W.value).toInt()
            val fetched_temp = remember { mutableStateOf(23.0) }
            Vehicle_temp(fetched_temp.value, h, w)


        }
        //3-tirepressure
        Box(
            modifier = Modifier
                .padding((0.64 * W.value).dp, (0.1 * H.value).dp, 0.dp, 0.dp)
                .height((0.22 * H.value).dp)
                .width((0.16 * W.value).dp)
        ) {
            val tirePress = remember { mutableStateOf(110f) }
            TirePressure(tirePress.value, (0.16 * W.value).toInt(), (0.22 * H.value).toInt())
        }
        //4-measure
        Box(
            modifier = Modifier
                .padding((0.84 * W.value).dp, (0.14 * H.value).dp, 0.dp, 0.dp)
                .height((0.3 * H.value).dp)
                .width((0.16 * W.value).dp)
//                .background(color = Color.Red)
        ) {
            val measure = remember { mutableStateOf(80) }
            Measure(measure.value, (0.15 * W.value).toInt(), (0.3 * H.value).toInt())
        }

        Box(
            modifier = Modifier
                .padding((0.74 * W.value).dp, (0.7 * H.value).dp, 0.dp, 0.dp)
                .height((0.4 * H.value).dp)
                .width((0.35 * W.value).dp)
//                .background(color = Color.Red)
        ) {
            CarIcon((0.35 * W.value).toInt(), (0.4 * H.value).toInt())
        }
        //5-Energy consumption
        Box(
            modifier = Modifier
                .padding(
                    (W.value * 0.6).dp,
                    (H.value * 0.42).dp,
                    0.dp, 0.dp

                )
                .width((W.value * 0.35).dp)
                .height((H.value * 0.25).dp)
//                .background(color = Color.Red)
        ) {
            val remaining = remember { mutableStateOf(60.00) }
            val Average = remember { mutableStateOf(60.00) }
            val Fuel = remember { mutableStateOf(60.00) }
            //replace original values
            Energy_comp(
                remaining.value,
                Average.value,
                Fuel.value,
                200,
                100.0,
                (W.value * 0.35).toInt(),
                (H.value * 0.25).toInt()
            )
        }

        //6-Speedometer

        Box(
            modifier = Modifier
                .padding(
                    (W.value * 0.4).dp,
                    (H.value * 0.55).dp,
                    0.dp, 0.dp

                )
                .width((W.value * 0.3).dp)
                .height((W.value * 0.3).dp)
//                .background(color = Color.Red)
        ){

            Speedometer_bars(70f,160f,(0.3*W.value/400).toFloat())
            Speedometer_bg(70f,160f,(0.5*W.value/400).toFloat())
        }
    }
}
