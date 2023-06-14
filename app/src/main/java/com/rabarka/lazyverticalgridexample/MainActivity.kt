package com.rabarka.lazyverticalgridexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabarka.lazyverticalgridexample.ui.theme.LazyVerticalGridExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyGridExample(listOfCat = catList(), modifier = Modifier)

                }
            }
        }
    }
}

@Composable
fun LazyGridExample(listOfCat: List<Cat>, modifier: Modifier) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
        items(listOfCat) { cat ->
            CatCard(cat = cat, modifier = modifier.padding(4.dp))
        }
    }
}

@Composable
fun CatCard(cat: Cat, modifier: Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = cat.imageResId),
                contentDescription = stringResource(id = cat.stringResId),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(id = cat.stringResId))
        }
    }
}

fun catList(): List<Cat> {
    return listOf(
        Cat(R.drawable.cat_1, R.string.cat_1),
        Cat(R.drawable.cat_2, R.string.cat_2),
        Cat(R.drawable.cat_3, R.string.cat_3),
        Cat(R.drawable.cat_4, R.string.cat_4),
        Cat(R.drawable.cat_5, R.string.cat_5),
        Cat(R.drawable.cat_6, R.string.cat_6),
        Cat(R.drawable.cat_7, R.string.cat_7),
        Cat(R.drawable.cat_8, R.string.cat_8),
        Cat(R.drawable.cat_9, R.string.cat_9)
    )
}


@Composable
fun LazySimpleList() {
    val listOfName = listOf("India", "China", "Pakistan", "Japan", "USA", "UK", "Canada", "UAE")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(listOfName) {
            Text(text = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NameShower() {
    LazySimpleList()
}


@Preview(showBackground = true)
@Composable
fun CatListShower() {
    LazyGridExample(listOfCat = catList(), modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun CatCardShower() {
    CatCard(Cat(R.drawable.cat_1, R.string.cat_1), modifier = Modifier)
}
