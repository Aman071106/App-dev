package com.example.bankingapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Euro
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun CurrencySection() {
    val Currencies = listOf(
        Currency("USD", "27.53", "27.4", Icons.Outlined.AttachMoney),
        Currency("EURO", "13.45", "78.3", Icons.Outlined.Euro),
        Currency("YEN", "22.22", "57.8", Icons.Outlined.AttachMoney),
        Currency("USD", "27.53", "27.4", Icons.Outlined.AttachMoney),
        Currency("EURO", "13.45", "78.3", Icons.Outlined.Euro),
        Currency("YEN", "22.22", "57.8", Icons.Outlined.AttachMoney),
    )

    //states
    val iconState = remember { mutableStateOf(270f) }
    val isVisible = remember { mutableStateOf(false) }
    //onclick
    val onclick: () -> Unit = {
        isVisible.value = !isVisible.value
        iconState.value = (iconState.value + 180) % 360
    }
    Box(
        modifier = Modifier.fillMaxSize()

//        .background(Color.Blue)
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                        color = MaterialTheme.colorScheme.secondaryContainer
                    )
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = null,
                        tint = Color.White,

                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                            .rotate(iconState.value)
                            .padding(4.dp)
                            .clickable { onclick() }


                    )
                    Box(modifier = Modifier.width(10.dp)) {}
                    Text("Currencies", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }

            if (isVisible.value) {
                HorizontalDivider(
                    thickness = 5.dp,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                        .background(Color.White)

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween
                    ) {
                        Text("Currency", fontWeight = FontWeight.Bold)
                        Text("Buy", fontWeight = FontWeight.Bold)
                        Text("Sell", fontWeight = FontWeight.Bold)
                    }
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        items(Currencies.size) { i ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row {
                                    Icon(
                                        imageVector = Currencies[i].icon,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier
                                            .padding(4.dp)
                                            .clip(shape = RoundedCornerShape(10.dp))
                                            .background(Color.Green)
                                    )
                                    Text(text = Currencies[i].type, fontWeight = FontWeight.W800)
                                }
                                Text(text = "$ " + Currencies[i].buy)
                                Text(text = "$ " + Currencies[i].sell)
                            }

                        }
                    }
                }
            }

        }
    }
}


