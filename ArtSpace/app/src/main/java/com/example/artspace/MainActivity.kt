package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceHomeContainerView()
            }
        }
    }
}

@Composable
fun ArtSpaceHomeContainerView() {
    var index by remember {
        mutableStateOf(0)
    }
    Surface(
        color = Color.Black.copy(alpha = 0.05f),
        modifier = Modifier
            .fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(Modifier.padding(16.dp))

            PictureCardView(item = DataManager().dataArray[index])

            TextCardView(item = DataManager().dataArray[index])

            ButtonRow(previousButtonTapped = {
                if (index == 0) {
                    index = 2
                } else {
                    index -= 1
                }
            },
            nextButtonTapped = {
                if (index == 2) {
                    index = 0
                } else {
                    index += 1
                }
            })

        }
    }
}

@Composable
fun PictureCardView(item: Item) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = 12.dp
//        border = BorderStroke(width = 4.dp, color = Color.Black)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = stringResource(item.imageName),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TextCardView(item: Item) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                stringResource(
                    id = item.imageName),
                    fontSize = 28.sp
            )

            Text(
                stringResource(
                    id = item.imageCapturedBy),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
            )
        }

    }
}

@Composable
fun ButtonRow(previousButtonTapped: () -> Unit, nextButtonTapped: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = { previousButtonTapped() }) {
            Text("Previous")
        }

        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = { nextButtonTapped() }) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceHomeContainerView()
    }
}