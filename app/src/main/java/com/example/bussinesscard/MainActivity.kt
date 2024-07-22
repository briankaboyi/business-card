package com.example.bussinesscard

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xffd2e8d4)) { innerPadding ->

                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxHeight()) {
                        Spacer(modifier = Modifier.weight(1f))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            ImageItem()
                            TextItem("Jane Doe", fontSize = 24, fontWeight = FontWeight.W400)
                            TextItem(
                                "Title",
                                fontSize = 14,
                                fontWeight = FontWeight.W600,
                                color = Color(0xff006d3b)
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        ContactsDetails()

                    }
                }
            }
        }
    }
}

@Composable
fun TextItem(
    name: String,
    modifier: Modifier = Modifier,
    fontSize: Int,
    fontWeight: FontWeight = FontWeight.W300, color: Color = Color.Black
) {
    Text(
        text = name,
        modifier = modifier,
        style = TextStyle(fontSize = fontSize.sp, fontWeight = fontWeight, color = color)
    )
}

@Composable
fun ImageItem(modifier: Modifier = Modifier.size(190.dp)) {
    val image = painterResource(id = R.drawable.ic_launcher_foreground);
    val bd_image = painterResource(id = R.drawable.ic_launcher_background);
    Box {

        Image(
            painter = bd_image,
            contentDescription = null,
            modifier = modifier, contentScale = ContentScale.Crop
        )
        Image(
                painter = image,
        contentDescription = null,
        modifier = modifier, contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ContactRow(text: String, icon: ImageVector) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(bottom = 12.dp)
    ) {
        Icon(
            icon,
            contentDescription = "Localized description",
            tint = Color(0xff006d3b),
            modifier = Modifier.size(16.dp)
        )
        TextItem(
            text,
            fontSize = 14,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun ContactsDetails() {
    Box(contentAlignment = Alignment.CenterStart, modifier = Modifier) {

        Column(
            horizontalAlignment = Alignment.Start,

        ) {
            ContactRow(text = "+11 (123) 444 555 666", icon = Icons.Filled.Phone)
            ContactRow(text = "@AndriodDev", icon = Icons.Filled.Share)
            ContactRow(text = "jen@doe.android.com", icon = Icons.Filled.Email)
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color(0xffd2e8d4)) { innerPadding ->

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ImageItem()
                    TextItem("Jane Doe", fontSize = 24, fontWeight = FontWeight.W400)
                    TextItem(
                        "Title",
                        fontSize = 14,
                        fontWeight = FontWeight.W600,
                        color = Color(0xff006d3b)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                ContactsDetails()

            }
        }
    }


}
