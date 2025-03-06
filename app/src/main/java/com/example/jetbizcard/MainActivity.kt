package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizcardTheme {
                CreateBizcard()
            }
        }
    }
}

@Composable
fun CreateBizcard() {

    // keeps track of when the button to show portfolio
    val buttonClickedState = remember {
        mutableStateOf(value = false)
    }

    // main background
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {

        // card background
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(40.dp)),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            // column for the main content
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // profile icon
                CreateImageProfile()

                // divider under the profile picture
                HorizontalDivider(modifier = Modifier.padding(top = 10.dp))

                // profile text info
                CreateUserDetails()

                // portfolio button
                CreatePortfolioButton(buttonClickedState)
            }
        }
    }
}

// UI for the clickable portfolio button.
@Composable
private fun CreatePortfolioButton(buttonClickedState: MutableState<Boolean>) {
    Button(
        modifier = Modifier
            .padding(1.dp),
        onClick = {
            buttonClickedState.value = !buttonClickedState.value
        }) {
        Text(
            modifier = Modifier,
            text = "Portfolio",
            fontSize = 17.sp
        )
    }

    // display content when the button is clicked.
    if (buttonClickedState.value) {
        Content()
    }
    else {
        Box() { }
    }
}

@Composable
private fun CreateUserDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(3.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // user name
        Text(
            modifier = Modifier
                .padding(top = 10.dp),
            fontSize = 37.sp,
            color = Color.Blue,
            text = "Adrian Toscano",
        )

        // user job title
        Text(
            modifier = Modifier,
            fontSize = 17.sp,
            text = "Android Developer"
        )

        // social media handle
        Text(
            modifier = Modifier,
            fontSize = 17.sp,
            text = "@AyDrean__"
        )
    }
}

// UI for the profile icon
@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {

    // circle shape
    Surface(
        modifier = Modifier
            .padding(13.dp)
            .size(160.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.LightGray),
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f)
    ) {

        // image used inside the circle
        Image(
            modifier = Modifier
                .graphicsLayer(scaleX = 1.5f, scaleY = 1.5f),
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun Content() {
    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
        Surface (
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data) { item ->

            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape
            ) {
                Row (
                    modifier = Modifier
                        .padding(16.dp)
                ){
                    CreateImageProfile()
                }
            }

        }
    }
}

// @Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizcardTheme {
        CreateBizcard()
    }
}