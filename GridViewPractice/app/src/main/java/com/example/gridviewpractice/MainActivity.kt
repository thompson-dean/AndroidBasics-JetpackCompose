package com.example.gridviewpractice


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridviewpractice.data_source.DataSource
import com.example.gridviewpractice.model.Topic
import com.example.gridviewpractice.ui.theme.GridViewPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridViewPracticeTheme {
                GridViewApp()
            }
        }
    }
}

@Composable
fun GridViewApp() {
    GridView(topics = DataSource.topics)
}

@Composable
fun GridItem(topic: Topic) {
    Card(elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.topicImageId),
                contentDescription = null,
            modifier = Modifier
                .size(width = 68.dp, height = 68.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Crop)



            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id = topic.topicStringId),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                ))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "*",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Text(
                        text = topic.topicInt.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GridView(topics: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)) {
        items(topics) { topic ->
            GridItem(topic = topic)
        }
    }
}

@Preview
@Composable
fun GridItemPreview() {
    GridViewPracticeTheme {
        val topic = Topic(R.string.photography, 321, R.drawable.photography)
        GridItem(topic = topic)
    }
}