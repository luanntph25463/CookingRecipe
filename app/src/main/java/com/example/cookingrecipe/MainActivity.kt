package com.example.cookingrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cookingrecipe.ui.theme.CookingRecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookingRecipeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    app()
                }
            }
        }
    }
}

@Composable
fun banner(modifier: Modifier) {

}

@Composable
fun app(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            // fill max màn hình
            .fillMaxWidth()
            .offset(0.dp, (-150).dp)
        // kéo ảnh lên phía trên
        ,
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Header Background",
        contentScale = ContentScale.FillWidth
    )
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Xử lý khi IconButton 1 được nhấp */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.line),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Virgin Mojito",
                    textAlign = TextAlign.Center,
                    style = typography.titleLarge,
                    color = Color.Red
                )
            }

            IconButton(onClick = { /* Xử lý khi IconButton 2 được nhấp */ }) {
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = null
                )
            }
        }
        Row() {
            Column() {
                Text(
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.titleSmall,
                    text = stringResource(id = R.string.Header),
                    color = Color.Gray
                )
            }
        }
        Row(
            Modifier
                .padding(top = 10.dp)
        ) {
            Column(
                modifier = modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = "Time",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "25 min",
                    fontSize = 30.sp,
                    color = Color.Black,

                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Difficulty",
                    fontSize = 20.sp,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Medium",
                    fontSize = 38.sp,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Category",
                    fontSize = 20.sp,
                    color = Color.Cyan,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Sweet",
                    fontSize = 36.sp,
                    color = Color.Cyan,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Serves",
                    fontSize = 20.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "2",
                    fontSize = 20.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(

                painter = painterResource(R.drawable.image4),
                contentDescription = "",
                modifier = Modifier
                    .width(250.dp)
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding()) {
                Text(
                    modifier = Modifier,
                    fontSize = 28.sp,
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold,
                    text = "Ingredients >"
                )
            }
            AlignYourBodyRowsellerItem()

        }
    }
}

@Composable
fun AlignYourBodyRowsellerItem(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(alignYourBodyDataSeller) { item ->
            AlignYourBodyElementSeller(item.drawable, item.text, item.seller)
        }
    }
}

@Composable
fun AlignYourBodyElementSeller(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes seller: Int,
    modifier: Modifier = Modifier
) {
    // gắn     horizontalAlignment = Alignment.CenterHorizontally vào giữa
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.image1),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier.paddingFromBaseline(top = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Row {
                Text(
                    "300",
                    textDecoration = if (1 > 0)
                        TextDecoration.LineThrough
                    else
                        TextDecoration.None,
                    color = if (1 > 0) Color.Gray else Color.Black
                )
                if (1 > 0) {
                    Text(text = "[$1%]", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}

private val alignYourBodyDataSeller = listOf(
    Pair(Pair(R.drawable.image2, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.image1, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.image3, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.image5, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.image6, R.string.app_name), R.string.app_name),
    Pair(Pair(R.drawable.image5, R.string.app_name), R.string.app_name)
).map { (drawableTextPair, sellerRes) ->
    val (drawableRes, textRes) = drawableTextPair
    DrawableStringPairSeller(drawableRes, textRes, sellerRes)
}

private data class DrawableStringPairSeller(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    @StringRes val seller: Int
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CookingRecipeTheme {
        app()
    }
}