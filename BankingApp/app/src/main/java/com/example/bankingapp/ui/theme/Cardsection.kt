package com.example.bankingapp.ui.theme

import android.media.Image
import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.R


@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun CardSection(h: Int = 800, w: Int = 400) {
    val listOfCardsMap = listOf(
        R.drawable.visa_logo_2, R.drawable.mastercard, R.drawable.pnb
    )
    val ColorList = listOf(Color.Magenta, Color.Green, Color.Blue)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
            .padding(16.dp),
    ) {
        items(listOfCardsMap.size) { i ->
            CardUi(h, w, color = ColorList[i], listOfCardsMap[i], balance = (i + 1) * 43.2)

        }
    }

}


@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun CardUi(
    h: Int = 800,
    w: Int = 400,
    color: Color = Color.Magenta,
    resourceId: Int = R.drawable.mastercard,
    type: String = "Savings",
    balance: Double = 13.44,
    acno: Long = 2332666676830987
) {

    Box(
        modifier = Modifier
            .height((0.25 * h).dp)
            .width((0.75 * w).dp)
            .padding(10.dp)
            .shadow(
                elevation = 4.dp,
                spotColor = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(shape = RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        color, Color.Cyan
                    )
                ),
            )

            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
//                .background(Color.Red)
        ) {
            Image(
                painter = painterResource(resourceId), contentDescription = null,
                Modifier
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight(0.25f),
            )
            Spacer(Modifier.height(10.dp))
            Column (modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom
            ){
                Text(
                    type,
                    Modifier.padding(start = 4.dp),
                    color = Color.White,
                    fontWeight = FontWeight.W700, fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "$ $balance",
                    fontSize = 20.sp,
                    letterSpacing = 1.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "${acno.toString().subSequence(0, 4)} ${
                        acno.toString().subSequence(4, 8)
                    } ${acno.toString().subSequence(8, 12)} ${acno.toString().subSequence(12, 16)}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.White
                )
            }
        }
    }

}

