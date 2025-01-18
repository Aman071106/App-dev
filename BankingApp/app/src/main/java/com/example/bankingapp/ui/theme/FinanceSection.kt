package com.example.bankingapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Business
import androidx.compose.material.icons.rounded.Dataset
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, heightDp = 800, widthDp = 400)
@Composable
fun FinanceSection(w: Int = 400) {

    val Financeitems = listOf(
        FinItem("My\nWallet", Icons.Rounded.Wallet, Color.Blue),
        FinItem("My\nBusiness", Icons.Rounded.Business, Color.Green),
        FinItem("Finance\nAnalysis", Icons.Rounded.Star, Color.Cyan),
        FinItem("Stock\nAnalysis", Icons.Rounded.Dataset, Color.Yellow)
    )
    Column(
        modifier = Modifier
            .wrapContentHeight()
//        .background(Color.Blue)
            .padding(4.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp),
            text = "Finance",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
        LazyRow(
            modifier = Modifier
                .height((0.35 * w).dp) //assuming h=2w on average otherwise take h as input
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            items(Financeitems.size) { i ->
                FinanceItem(w, Financeitems[i])

            }
        }
    }

}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun FinanceItem(
    w: Int = 400, item: FinItem = FinItem("My\nWallet", Icons.Rounded.Wallet, Color.Blue)
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width((0.33 * w).dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
//            .background(Color.Blue)
            , verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = item.icon,
                contentDescription = null,
                modifier = Modifier
                    .background(color = item.iconBgColor)
                    .padding(2.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Text(
                text = item.work,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 20.sp
            )
        }
    }
}



