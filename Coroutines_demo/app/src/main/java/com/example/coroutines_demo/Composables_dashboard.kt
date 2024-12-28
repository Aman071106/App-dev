package com.example.coroutines_demo

import android.health.connect.datatypes.units.Energy
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.time.measureTime
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

//1-battery ui

@Composable
fun Battery(batteryLevel: Float) {
    // Box to hold the battery bar
    Box(modifier = Modifier.fillMaxSize()) {


        // Draw the battery level inside the background image
        Canvas(
            modifier = Modifier
                .align(Alignment.TopCenter) // Center it inside the parent Box
                .fillMaxWidth(0.8f) // Adjust the width to 80% of the parent width
                .fillMaxHeight(1f) // Adjust the height to 80% of the parent height
        ) {
            // Calculate the battery bar height based on the level
            val normalizedBatteryLevel = batteryLevel / 100f
            val barHeight =
                size.height * normalizedBatteryLevel // Scale the height based on battery level
            val barWidth = size.width // Use the full width available

            // Draw Red Gradient Bar (Scaled by normalized batteryLevel)
            drawGradientBar(normalizedBatteryLevel, barWidth, barHeight)
        }
    }
}

fun DrawScope.drawGradientBar(normalizedBatteryLevel: Float, width: Float, height: Float) {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFFB4C913), Color(0xFFFD2200)),
        startY = 0f,
        endY = height
    )
    drawRoundRect(
        brush = gradientBrush,
        topLeft = Offset(0f, size.height - height), // Position at the bottom of the canvas
        size = Size(width, height) // Use the width and height calculated
        , cornerRadius = CornerRadius.Zero.copy(5.dp.toPx(), 5.dp.toPx())
    )
}

//@Preview
@Composable
fun PreviewBattery() {
    Battery(batteryLevel = 100f)
}


//2-vehicle temp
//@Preview
@Composable
fun Vehicle_temp(temp: Double = 23.0, imageHeight: Int = 134, imageWidth: Int = 102) {
    val temp_v = temp.toInt()
    val safetyMessage = when (temp_v) {
        in 0..10 -> "Feels Safe"
        in 11..20 -> "Okay"
        in 21..30 -> "Caution"
        in 31..40 -> "Danger"
        else -> "Unknown"
    }



    Box(
        modifier = Modifier
            .width((imageWidth).dp)
            .height((imageHeight).dp)

    ) {
        // Display the image as the background
        Image(
            painter = painterResource(id = R.drawable.temp_vehicle),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Dynamic positions and sizes based on image dimensions
        Text(
            text = "TEMPERATURE",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                start = (imageWidth * 0.058f).dp, // 5% from the left
                top = (imageHeight * 0.08f).dp // 8% from the top
            )
        )
        Text(
            text = safetyMessage.toUpperCase(),
            color = Color.White,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                start = (imageWidth * 0.065f).dp, // 10% from the left
                top = (imageHeight * 0.55f).dp // 50% from the top
            )
        )
        Text(
            text = "${temp_v}°C",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                start = (imageWidth * 0.07f).dp, // 20% from the left
                top = (imageHeight * 0.39f).dp // 25% from the top
            )
        )

        // Lines and slider
        Box(modifier = Modifier.width((imageWidth).dp)) {
            Row(
                modifier = Modifier
                    .padding(
                        start = (imageWidth * 0.12f).dp,
                        top = (imageHeight * 0.8f).dp,
                        end = (imageWidth * 0.15f).dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                getlistofLines(10, "#2B2B2B").map { item ->
                    line(item.color, Modifier.height((imageHeight * 0.057).dp))
                }
            }
            Slider(
                value = temp.toFloat(),
                onValueChange = {},
                valueRange = 0f..40f,
                modifier = Modifier.padding(
                    start = (imageWidth * 0.009f).dp,
                    top = (imageHeight * 0.65f).dp,
                    end = (imageWidth * 0.009f).dp
                ),
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFFFFA500), // Orange color for the thumb
                    activeTrackColor = Color(0xFFFFA500), // Orange color for the active track
                    inactiveTrackColor = Color(0xFFFFE4B5) // Light orange for the inactive track
                )
            )
        }
    }
}


//3-tire pressure ui
@Composable
fun TirePressure(tirePressure: Float, imageWidth: Int, imageHeight: Int) {
    val h = imageHeight
    val w = imageWidth
    Box(
        modifier = Modifier
//            .padding((w*0.01).dp,(h*0.001).dp) // Add padding for better spacing
    )
    {
        Image(
            painter = painterResource(id = R.drawable.tyre_pressure), // Replace with your image resource
            contentDescription = "Tire Pressure Icon",
            modifier = Modifier
                .width(imageWidth.dp)
                .height(imageHeight.dp) // Set a fixed size for consistency

        )
        Text(
            text = "${tirePressure.toInt()} psi",
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )

    }
}

//@Preview(showBackground = true)
@Composable
fun TirePreview() {
    TirePressure(32f, 101, 108)
}


//4-Measure
//@Preview
@Composable
fun Measure(measure: Int = 80, imageWidth: Int = 83, imageHeight: Int = 144) {
    val message = when (measure) {
        in 0..10 -> "Feels Safe"
        in 11..20 -> "Okay"
        in 21..30 -> "Caution"
        in 31..40 -> "Danger"     //Later change as per requirement
        else -> "Unknown"
    }
    Box(
        modifier = Modifier
            .width(imageWidth.dp)
            .height(imageHeight.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.measure),
            contentDescription = null, contentScale = ContentScale.FillBounds
        )
        Text(
            text = measure.toString(),
            color = Color.LightGray,
            modifier = Modifier.padding((0.44 * imageWidth).dp, (0.3 * imageHeight).dp, 0.dp, 0.dp),
            fontSize = 16.sp
        )
        Text(
            text = message,
            color = Color.Black,
            modifier = Modifier.padding(
                (0.073 * imageWidth).dp,
                (0.63 * imageHeight).dp,
                0.dp,
                0.dp
            ),
            fontSize = 8.sp
        )
    }
}


//Car Icon

/*date time
@Composable
fun date_time(date:String,time:String){
    Column() {
        Text(
            text=time
        )
        Text(
            text=date
        )
    }
}
*/

//@Preview
@Composable
fun icon_prev() {
    CarIcon()
}

@Composable
fun CarIcon(imageWidth: Int = 40, imageHeight: Int = 40) {
    Image(
        painter = painterResource(id = R.drawable.car_image),
        contentDescription = null,
        modifier = Modifier
            .width((imageWidth).dp)
            .height((imageHeight).dp)
    )
}

//5-Energy consumption
//@Preview
@Composable
fun Energy_comp(
    remaining: Double = 60.00,
    Average: Double = 90.00,
    Fuel: Double = 70.00,
    maxKms: Int = 200, // Replace with your actual value
    maxFuel: Double = 100.00,
    imageWidth: Int = 469,
    imageHeight: Int = 180
) // Replace with your actual value
{
    val Remaining = remember { mutableStateOf(remaining) }
    val maxEnergy = maxKms * maxFuel
    val currentEnergy = remaining * Fuel
    val energyPercentage = (currentEnergy / maxEnergy)

    val linesState = remember { mutableStateOf(getlistofLines(20, "#9D624B")) }

    Box(
        modifier = Modifier
            .width((imageWidth).dp)
            .height((imageHeight).dp)
//         .background(color = Color.Red)
    ) {
        Image(
            painter = painterResource(R.drawable.energy_consumption),
            contentDescription = "energy_Consumption",
            modifier = Modifier.width((imageWidth).dp)
                .height((imageHeight).dp)

        )
        Column(
            modifier = Modifier.padding(
                (imageWidth * 0.035).dp,
                (imageHeight * 0.2).dp,
                (imageWidth * 0.066).dp,
                (imageHeight * 0.074).dp
            )
        ) {
            Text(
                text = "ENERGY CONSUMPTION",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 10.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding((imageWidth * 0.2).dp,
                        (imageHeight * 0.0625).dp,
                        (imageWidth * 0.2).dp,
                        (imageHeight * 0.10).dp)
                    .fillMaxWidth()
            ) {
                linesState.value.forEach { item ->
                    line(item.color, Modifier.height((0.103*imageHeight).dp))
                }
            }

            Row(
                horizontalArrangement = Arrangement.Absolute.Center, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${Remaining.value.toInt()} km    \nRange", textAlign = TextAlign.Center,

                    color = Color.White,
                    fontSize = 7.sp
                )
                Text(
                    text = "${Average.toInt()} wh/km     \nAvg", textAlign = TextAlign.Center,

                    color = Color.White,
                    fontSize = 7.sp
                )
                Text(
                    text = "${Fuel.toInt()} Kwh  \nFuel", textAlign = TextAlign.Center,

                    color = Color.White,
                    fontSize = 7.sp
                )
            }
        }
    }
    LaunchedEffect(energyPercentage) {
        val darkBars = (20 * energyPercentage).toInt()
        val updatedLines = linesState.value.toMutableList()
        for (i in 1..darkBars) {
            updatedLines[i - 1] = lines("#FF9501")
        }
        linesState.value = updatedLines
    }
}


//6-Speedometer
//@Preview
@Composable
fun Speedometer_bars(speed: Float = 60f, maxSpeed: Float = 160f, scaleFactor: Float = 1f) {
    Box(
        Modifier.size((400 * scaleFactor).dp) // Scale the size of the entire speedometer
    ) {

        val numMarkers = 40
        val anglePerMarker = 270f / numMarkers
        val majorMarkerLength = 120f * scaleFactor
        val minorMarkerLength =60f * scaleFactor

        Canvas(
            modifier = Modifier
                .width((280 * scaleFactor).dp)
                .height((280 * scaleFactor).dp).align(Alignment.Center)
        ) {
            val offsetX = 0f * scaleFactor
            val offsetY = 50f * scaleFactor
            val center = Offset(size.width / 2 + offsetX, size.height / 2 + offsetY)
            val radius = size.width / 2 - 15 * scaleFactor
            val arcRadius = radius + 15f * scaleFactor
            val startAngle = 132f
            val sweepAngle = 270f
            val filledSweepAngle = sweepAngle * (speed / maxSpeed)

            drawArc(
                color = Color(0xFFDA7E0B),
                startAngle = startAngle,
                sweepAngle = filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            drawArc(
                color = Color(0xFF7F6957),
                startAngle = startAngle + filledSweepAngle,
                sweepAngle = sweepAngle - filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            for (i in 0..numMarkers) {
                val angle = startAngle + anglePerMarker * i
                val color = if (speed >= (maxSpeed * i) / numMarkers) {
                    Color(0xFFF7800D)
                } else {
                    Color(0xFF7F6957)
                }

                val startOffset = Offset(
                    x = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                )
                val endOffset = Offset(
                    x = center.x + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            sin(Math.toRadians(angle.toDouble())).toFloat()
                )

                drawLine(
                    color = color,
                    start = startOffset,
                    end = endOffset,
                    strokeWidth = 5f * scaleFactor
                )
            }
        }
    }
}
//@Preview
@Composable
fun Speedometer_bg(speed: Float = 60f, maxSpeed: Float = 160f, scaleFactor: Float = 1f) {
    Box(
        Modifier.size((400 * scaleFactor).dp) // Scale the size of the entire speedometer
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_10),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(Color(0xFFF48622)),
            modifier = Modifier
                .fillMaxSize() // Make the image fill the Box
                .size((400 * scaleFactor).dp) // Scale the image size dynamically
        )

        Box(
            modifier = Modifier
                .padding(
                    start = (0*scaleFactor).dp,
                    top = (30 * scaleFactor).dp
                )
                .size((60 * scaleFactor).dp)
                .background(Color.Transparent, CircleShape)
                .border(1.dp, Color(0xFF7F6957), CircleShape)
                .align(Alignment.Center)
        ) {
            Text(
                text = "$speed",
                modifier = Modifier.align(Alignment.Center),
                fontSize = (20 * scaleFactor).sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Km/h",
                modifier = Modifier.padding(
                    start = (45 * scaleFactor).dp,
                    top = (80 * scaleFactor).dp
                ),
                fontSize = (18 * scaleFactor).sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }

    }
}


//@Preview
@Composable
fun Speedometer(speed: Float = 60f, maxSpeed: Float = 160f) {
    Box(Modifier.size(400.dp)) { // Speedometer size

        Image(
            painter = painterResource(id=R.drawable.vector_10),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier.padding(132.dp,160.dp,0.dp,0.dp)
                .size(130.dp) // Set size of the circle
                .background(color = Color.Transparent, shape = CircleShape) // Circle shape
                .border(1.dp, Color(0xFFFFE4B5), CircleShape) // Border with a 2dp width and light yellow color
        ) {
            Text(
                text = "$speed",
                modifier = Modifier.align(Alignment.Center), // Center text both horizontally and vertically
                fontSize = 20.sp,
                color = Color.White, // Set text color
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Km/h",
                modifier = Modifier.padding(45.dp,80.dp,0.dp,0.dp), // Center text both horizontally and vertically
                fontSize = 18.sp,
                color = Color.LightGray, // Set text color
                textAlign = TextAlign.Center
            )
        }

        val numMarkers = 40 // Number of markers (total of major and minor)
        val anglePerMarker = 270f / numMarkers // Angle per marker
        val majorMarkerLength = 100f // Length of the major marker (long line)
        val minorMarkerLength = 50f // Length of the minor marker (short line)

        // Colors for markers based on speed or any condition
        val getColor = { index: Int ->
            if (speed >= (maxSpeed * (index)) / numMarkers) {
                Color(0xFFFFA500) // Orange for higher speeds
            } else {
                Color(0xFFFFE4B5) // Light orange for lower speeds
            }
        }

        Canvas(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)

        ) {
            val offsetX = 120f // Horizontal offset
            val offsetY = 220f // Vertical offset

            val center = Offset(size.width / 2 + offsetX, size.height / 2 + offsetY) // Apply offset to center

            val radius = size.width / 2 - 15 // Set the radius to draw lines within the circle

            // Dynamic arc radius
            val arcRadius = radius + 15f // Slightly larger radius for the arc
            val startAngle = 135f
            val sweepAngle = 270f // The total arc spans 270 degrees

            // Draw the filled arc for the dynamic speed
            val filledSweepAngle = (sweepAngle * (speed / maxSpeed)) // Sweep angle for the current speed
            drawArc(
                color = Color(0xFFFFA500), // Dark orange for the filled portion (up to speed)
                startAngle = startAngle,
                sweepAngle = filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2), // Correct size for the arc
                style = Stroke(width = 10f),
                topLeft = Offset(120f,220f)

            )

            // Draw the remaining arc for the rest of the range
            val remainingSweepAngle = sweepAngle - filledSweepAngle
            drawArc(
                color = Color(0xFFFFE4B5), // Light orange for the remaining portion
                startAngle = startAngle + filledSweepAngle, // Starting where the filled arc ends
                sweepAngle = remainingSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2), // Correct size for the arc
                style = Stroke(width = 10f),
                topLeft = Offset(120f,220f)// Stroke width for the arc
            )

            // Draw markers (alternating big and small lines)
            for (i in 0 until numMarkers + 1) {
                val angle = startAngle + anglePerMarker * i // Starting angle for each line
                val color = getColor(i)

                // Calculate the starting and ending points for the lines
                val startOffset = Offset(
                    x = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                )

                val endOffset = Offset(
                    x = center.x + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            sin(Math.toRadians(angle.toDouble())).toFloat()
                )

                // Draw the line
                drawLine(
                    color = color,
                    start = startOffset,
                    end = endOffset,
                    strokeWidth = 5f
                )
            }
        }
    }
}
//@Preview
@Composable
fun Speedometer2(speed: Float = 60f, maxSpeed: Float = 160f, scaleFactor: Float = 1f) {
    Box(
        Modifier.size((400 * scaleFactor).dp) // Scale the size of the entire speedometer
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_10),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize() // Make the image fill the Box
                .size((400 * scaleFactor).dp) // Scale the image size dynamically
        )

        Box(
            modifier = Modifier
                .padding(
                    start = (132 * scaleFactor).dp,
                    top = (160 * scaleFactor).dp
                )
                .size((130 * scaleFactor).dp)
                .background(Color.Transparent, CircleShape)
                .border(1.dp, Color(0xFFFFE4B5), CircleShape)
        ) {
            Text(
                text = "$speed",
                modifier = Modifier.align(Alignment.Center),
                fontSize = (20 * scaleFactor).sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Km/h",
                modifier = Modifier.padding(
                    start = (45 * scaleFactor).dp,
                    top = (80 * scaleFactor).dp
                ),
                fontSize = (18 * scaleFactor).sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }

        val numMarkers = 40
        val anglePerMarker = 270f / numMarkers
        val majorMarkerLength = 100f * scaleFactor
        val minorMarkerLength = 50f * scaleFactor

        Canvas(
            modifier = Modifier
                .width((300 * scaleFactor).dp)
                .height((300 * scaleFactor).dp)
        ) {
            val offsetX = 120f * scaleFactor
            val offsetY = 220f * scaleFactor
            val center = Offset(size.width / 2 + offsetX, size.height / 2 + offsetY)
            val radius = size.width / 2 - 15 * scaleFactor
            val arcRadius = radius + 15f * scaleFactor
            val startAngle = 135f
            val sweepAngle = 270f
            val filledSweepAngle = sweepAngle * (speed / maxSpeed)

            drawArc(
                color = Color(0xFFFFA500),
                startAngle = startAngle,
                sweepAngle = filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            drawArc(
                color = Color(0xFFFFE4B5),
                startAngle = startAngle + filledSweepAngle,
                sweepAngle = sweepAngle - filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            for (i in 0..numMarkers) {
                val angle = startAngle + anglePerMarker * i
                val color = if (speed >= (maxSpeed * i) / numMarkers) {
                    Color(0xFFFFA500)
                } else {
                    Color(0xFFFFE4B5)
                }

                val startOffset = Offset(
                    x = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                )
                val endOffset = Offset(
                    x = center.x + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            sin(Math.toRadians(angle.toDouble())).toFloat()
                )

                drawLine(
                    color = color,
                    start = startOffset,
                    end = endOffset,
                    strokeWidth = 5f * scaleFactor
                )
            }
        }
    }
}
//@Preview
@Composable
fun Speedometer3(speed: Float = 60f, maxSpeed: Float = 160f, scaleFactor: Float = 1f) {
    Box(
        Modifier.size((400 * scaleFactor).dp) // Scale the size of the entire speedometer
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_10),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize() // Make the image fill the Box
                .size((400 * scaleFactor).dp) // Scale the image size dynamically
        )

        Box(
            modifier = Modifier
                .padding(
                    start = (132 * scaleFactor).dp,
                    top = (160 * scaleFactor).dp
                )
                .size((130 * scaleFactor).dp)
                .background(Color.Transparent, CircleShape)
                .border(1.dp, Color(0xFFFFE4B5), CircleShape)
        ) {
            Text(
                text = "$speed",
                modifier = Modifier.align(Alignment.Center),
                fontSize = (20 * scaleFactor).sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Km/h",
                modifier = Modifier.padding(
                    start = (45 * scaleFactor).dp,
                    top = (80 * scaleFactor).dp
                ),
                fontSize = (18 * scaleFactor).sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )
        }

        val numMarkers = 40
        val anglePerMarker = 270f / numMarkers
        val majorMarkerLength = 60f * scaleFactor
        val minorMarkerLength =25f * scaleFactor

        Canvas(
            modifier = Modifier
                .width((280 * scaleFactor).dp)
                .height((280 * scaleFactor).dp).align(Alignment.Center)
        ) {
            val offsetX = 0f * scaleFactor
            val offsetY = 50f * scaleFactor
            val center = Offset(size.width / 2 + offsetX, size.height / 2 + offsetY)
            val radius = size.width / 2 - 15 * scaleFactor
            val arcRadius = radius + 15f * scaleFactor
            val startAngle = 135f
            val sweepAngle = 270f
            val filledSweepAngle = sweepAngle * (speed / maxSpeed)

            drawArc(
                color = Color(0xFFFFA500),
                startAngle = startAngle,
                sweepAngle = filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            drawArc(
                color = Color(0xFFFFE4B5),
                startAngle = startAngle + filledSweepAngle,
                sweepAngle = sweepAngle - filledSweepAngle,
                useCenter = false,
                size = Size(arcRadius * 2, arcRadius * 2),
                style = Stroke(width = 10f * scaleFactor),
                topLeft = Offset(offsetX, offsetY)
            )

            for (i in 0..numMarkers) {
                val angle = startAngle + anglePerMarker * i
                val color = if (speed >= (maxSpeed * i) / numMarkers) {
                    Color(0xFFFFA500)
                } else {
                    Color(0xFFFFE4B5)
                }

                val startOffset = Offset(
                    x = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                )
                val endOffset = Offset(
                    x = center.x + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            cos(Math.toRadians(angle.toDouble())).toFloat(),
                    y = center.y + (radius - if (i % 5 == 0) majorMarkerLength else minorMarkerLength) *
                            sin(Math.toRadians(angle.toDouble())).toFloat()
                )

                drawLine(
                    color = color,
                    start = startOffset,
                    end = endOffset,
                    strokeWidth = 5f * scaleFactor
                )
            }
        }
    }
}



@Composable
fun line(color: String, m: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.line),
        contentDescription = "line",
        colorFilter = ColorFilter.tint(Color(android.graphics.Color.parseColor("$color"))),
        modifier = m
    )
}

data class lines(val color: String) {}

fun getlistofLines(no: Int, def_color: String): MutableList<lines> {
    val ans = mutableListOf<lines>()
    for (i in 1..no) {
        ans.add(lines("$def_color"))
    }
    return ans

}

@Composable
fun TestComposable() {
    val test = remember { mutableStateOf(1.0) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {
            test.value = test.value + 1
            Log.d("mytag", "update1")
        }) {
            Text(text = "test")
        }
//        Vehicle_temp(test.value)
    }
}


