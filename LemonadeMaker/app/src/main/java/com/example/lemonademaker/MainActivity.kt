package com.example.lemonademaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonademaker.ui.theme.LemonadeMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeMakerTheme {
                LemonadeMakerApp()
            }
        }
    }
}


@Composable
fun LemonadeMakerApp() {
    TextAndImageView(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Yellow.copy(alpha = 0.2f))
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun TextAndImageView(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(0)
    }
    var randomCount = 0
    val randomResult = (0..10).random()
    val stringArray: Array<String> = arrayOf(
        stringResource(id = R.string.tap_lemon_tree),
        stringResource(id = R.string.tap_lemon),
        stringResource(id = R.string.drink_lemonade),
        stringResource(id = R.string.empty_glass)
    )

    val imageResource = when(count) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }


    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Spacer(modifier = Modifier.fillMaxSize(0.5f))

        Text(
            "Lemonade Maker",
            modifier = Modifier
                .padding(horizontal = 52.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .height(height = 300.dp)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringArray[count])

            Spacer(modifier = Modifier.height(16.dp) )

            Image(
                painter = painterResource(id = imageResource), contentDescription = "1",
                modifier = Modifier
                    .background(color = Color.White)
                    .clickable {
                    if (count == 3) {
                        count = 0
                    } else if (count == 1) {
                        if (randomCount != randomResult) {
                            randomCount += 1
                        } else {
                            count += 1
                        }
                    } else {
                        count += 1
                        randomCount = 0
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeMakerTheme {
        LemonadeMakerApp()
    }
}

