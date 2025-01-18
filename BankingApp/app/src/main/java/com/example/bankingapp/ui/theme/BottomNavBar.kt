package com.example.bankingapp.ui.theme

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingapp.BottomNavBarItem


val items= listOf(
    BottomNavBarItem("Home", Icons.Rounded.Home),
    BottomNavBarItem("Wallet", Icons.Rounded.Wallet),
    BottomNavBarItem("Notification", Icons.Rounded.Notifications),
    BottomNavBarItem("Account", Icons.Rounded.AccountCircle)
)


@Preview(backgroundColor = Color.BLUE.toLong())
@Composable
fun BottomNavBar(){
    NavigationBar {
        Row(
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEachIndexed{index,item->
                NavigationBarItem(
                    selected = index==0,
                    onClick = {},
                    icon = { Icon(imageVector = item.icon,item.title, tint = MaterialTheme.colorScheme.onBackground) }
                    , label = {Text(text=item.title, color = MaterialTheme.colorScheme.onBackground)}
                )
            }
        }

    }
}