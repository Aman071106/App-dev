package com.example.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datamanager.DataManager
import com.example.datamanager.Quote




//@Preview(showBackground = true, widthDp = 340, heightDp = 640)
@Composable
fun QuoteListItem(h:Int=640,quote: Quote=Quote("Time is the most precious thing man can spend.","James Bond"),oncl:()->Unit){
    Card(
        modifier = Modifier
            .height((0.14*h).dp)
            .fillMaxWidth(1f)
            .padding(2.dp)
//            .background(color = Color.Red)          //debug
        , shape = RoundedCornerShape(16.dp)
        , elevation = CardDefaults.cardElevation(4.dp)
        , onClick = oncl
    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
//                .background(color = Color.Green)        //debug
        ){
            Image(
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.66f)
                    .padding(start=4.dp,top=8.dp)
                    .fillMaxWidth(0.15f)
                    .rotate(180f)
                    .background(color = Color.Black)
                , imageVector = Icons.Filled.FormatQuote
                , colorFilter = ColorFilter.tint(color = Color.White)
            )
            Column(
                modifier = Modifier.
                    padding(top=8.dp, bottom = 8.dp, start = 4.dp,end=2.dp)
                    .fillMaxWidth()
//                    .background(color = Color.Cyan) //debugging
            ){
                Text(modifier = Modifier.padding(1.dp),
                    text=quote.quote
                    , fontSize = 14.sp
                    , fontWeight = FontWeight.W600
                )
                Box(
                    modifier=Modifier
                        .padding(top=4.dp, bottom =3.dp)
                        .fillMaxWidth(0.5f)
                        .height(1.dp)
                        .background(color= Color.DarkGray)
                )
                {

                }
                Text(
                    text=quote.author,
                    fontSize = 14.sp
                    , fontWeight = FontWeight.W300
                )
            }
        }
    }

}

@Preview(showBackground = true, widthDp =340, heightDp = 640)
@Composable
fun Prev(){
    var showdetails= remember { mutableStateOf(false) }
    Column(modifier = Modifier.height(640.dp).width(340.dp)){
        QuoteListItem(640,Quote("Time is the most precious thing man can spend.","James Bond"),{showdetails.value=true})
    }
    QuoteDetail(640, quote =Quote("Time is the most precious thing man can spend.","James Bond"),showdetails.value)
}

@Preview(showBackground = true, widthDp =340, heightDp = 640)
@Composable
fun QuoteDetail(h:Int=640,quote: Quote=Quote("Time is the most precious thing man can spend.","James Bond"),isTrue: Boolean=true,oncl: () -> Unit={}){
    if(isTrue) {
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .background(
                    Brush.sweepGradient(
                        colors = listOf(
                            Color(0xFFffffff), Color(0xFFE3E3E3)

                        )
                    )
                )
        ) {

            Card(
                modifier = Modifier
                    .height((0.27 * h).dp)
                    .fillMaxWidth(0.85f)
                    .align(Alignment.Center)
//            .background(color = Color.Red)          //debug
                , shape = RoundedCornerShape(4.dp), elevation = CardDefaults.cardElevation(16.dp)
                , onClick = oncl
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
//                .background(color = Color.Green)        //debug
                ) {
                    Image(
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight(0.3f)
                            .padding(start = 5.dp, top = 8.dp)
                            .fillMaxWidth(0.15f)
                            .rotate(180f)
                            .background(color = Color.Black)
                        ,

                        imageVector = Icons.Filled.FormatQuote,
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )

                    Text(
                        modifier = Modifier.padding(start = 3.dp, top = 20.dp),
                        text = "Time is the most valuable thing that man can spend.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600
                    )

                    Text(
                        text = "James Bond",
                        fontSize = 16.sp, fontWeight = FontWeight.W500, modifier = Modifier
                            .padding(top = 15.dp)
                    )
                }
            }

        }
    }
}


//@Preview
@Composable
fun DisplayUi(h:Int,lis: DataManager){
    var showdetails= remember{mutableStateOf(false)}
    var qt= remember{mutableStateOf("")}
    var at= remember{mutableStateOf("")}
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ){
        item{Text(text = "Quotes App", modifier =Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 24.sp)}
//        item{QuoteListItem(h,Quote("Time is the most precious thing man can spend.","James Bond"))}
        items(lis.data.size){
            ele->
            QuoteListItem(h,lis.data[ele],{showdetails.value=true;qt.value=lis.data[ele].quote;at.value=lis.data[ele].author})
        }
    }
    QuoteDetail(h,Quote(qt.value,at.value),showdetails.value,{showdetails.value=false})
}

@Composable
fun LoadingScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(text="Loading...", fontSize = 24.sp, modifier = Modifier.align(Alignment.Center))
    }
}