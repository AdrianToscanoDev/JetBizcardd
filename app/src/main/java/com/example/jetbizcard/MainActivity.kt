package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                CreatePortfolioButton()
            }
        }
    }
}

@Composable
private fun CreatePortfolioButton() {
    Button(
        modifier = Modifier
            .padding(1.dp),
        onClick = {

        }) {
        Text(
            modifier = Modifier,
            text = "Portfolio",
            fontSize = 17.sp
        )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizcardTheme {
        CreateBizcard()
    }
}