package hackathon.smarttravel.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import hackathon.smarttravel.R


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToItem: () -> Unit,
) {
    LazyColumn {
        items(viewModel.uiState.value.items) { item ->
            CardItem(
                item = item,
                onNavigateToItem = onNavigateToItem,
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}


@Composable
fun CardItem(
    item: Item,
    onNavigateToItem: () -> Unit,
) {
    val paddingBottom = 30.dp
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Image(
                modifier = Modifier.size(150.dp, 165.dp),
                painter = painterResource(item.photo),
                contentDescription = "comfort",
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(bottom = paddingBottom),
                    text = item.name,
                )
                Text(
                    modifier = Modifier.padding(bottom = paddingBottom),
                    text = item.type,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        for (i: Int in 0..<item.personCount) {
                            Spacer(modifier = Modifier.padding())
                            Icon(
                                modifier = Modifier
                                    .size(20.dp, 20.dp)
                                    .padding(start = 5.dp)
                                    .align(Alignment.Bottom),
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = "person count",
                            )
                        }
                    }
                    Button(
                        modifier = Modifier
                            .size(width = 150.dp, height = 70.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = onNavigateToItem,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                fontSize = 14.sp,
                                text = "Забронировать",
                            )
                            Text(
                                fontSize = 12.sp,
                                text = "${item.price} ₽"
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CardItemPreview() {
    CardItem(
        item = previewItem,
        onNavigateToItem = {},
    )
}

val previewItem = Item(
    photo = R.drawable.comfort,
    name = "Комфорт",
    type = "Стандартный",
    price = 3000,
    personCount = 2,
    )
