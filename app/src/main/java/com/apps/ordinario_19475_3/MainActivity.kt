package com.apps.ordinario_19475_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apps.ordinario_19475_3.ui.theme.Ordinario_19475_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ordinario_19475_3Theme {
                CardPreview()
            }
        }
    }
}

@Composable
fun CardPreview() {
    val items = listOf(
        //Las Cards
        CardItem(1, "Adivina la edad", R.drawable.pastelin),
        CardItem(2, "Gatos", R.drawable.gato),
        CardItem(3, "NBA", R.drawable.nba),
        CardItem(4, "Chuck Norris", R.drawable.chuck)
    )
    LazyColumn {
        items(items.size) {
                index -> CardItemView(items[index])
        }
    }
}

data class CardItem(val number: Int, val title: String, val imageRes: Int)

@Composable
fun CardItemView(item: CardItem) {
    Card(
        modifier = Modifier.width(300.dp)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = item.number.toString(),
                modifier = Modifier.padding(end = 16.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "imagenes",
                    modifier = Modifier.size(64.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.title)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ordinario_19475_3Theme{
        CardPreview()
    }
}