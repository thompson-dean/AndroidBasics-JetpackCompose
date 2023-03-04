package com.example.project30daysofquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project30daysofquotes.data.Datasource
import com.example.project30daysofquotes.model.Quote
import com.example.project30daysofquotes.ui.theme.Project30DaysOfQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project30DaysOfQuotesTheme {
                QuoteApp()
            }
        }
    }
}

@Composable
fun QuoteApp() {
    val quotes = Datasource().data

    Scaffold(
        topBar = {
            QuoteTopAppBar()
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
                color = MaterialTheme.colors.background
        )
        {
            LazyColumn {
                items(quotes) {quote ->
                    QuoteCard(quote = quote)
                }
            }
        }
    }
}
@Composable
fun QuoteTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text("Random Quotes",
        style = MaterialTheme.typography.h1)
    }
}

@Composable
fun QuoteCard(quote: Quote) {
    val quoteString = quote.quote
    val indexString = quote.index.toString()
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(
            start = 8.dp,
            top = 8.dp,
            bottom = 8.dp,
            end = 8.dp
        )
        .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    elevation = 12.dp) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .padding(
                start = 16.dp,
                    top = 16.dp,
                    bottom = 8.dp,
                    end = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

            Text(text ="Day $indexString",
            style = MaterialTheme.typography.body1)

            Text(text = quote.author,
                style = MaterialTheme.typography.h3)

            Image(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp)),
                painter = painterResource(id = quote.image),
                contentDescription = quote.quote,
            contentScale = ContentScale.FillWidth
            )
            if (expanded) {
                Text(text = "\"$quoteString\"",
                    style = MaterialTheme.typography.body2)
            }

            Row() {
                QuoteItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded })
            }
        }
    }
}

@Composable
private fun QuoteItemButton(
    expanded: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.primary,
            contentDescription = "Tap to get quote"
        )
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreviewDark() {
    Project30DaysOfQuotesTheme {
        QuoteCard(Datasource().data[0])
    }
}