package hackathon.smarttravel.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import hackathon.smarttravel.R
import hackathon.smarttravel.ui.util.TopBar


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onNavigateToItem: () -> Unit,
) {
    Scaffold(
        topBar = { TopBar() },
    ) { innerPadding ->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ) {
            items(viewModel.uiState.value.items) { item ->
                CardItem(
                    item = item,
                    onNavigateToItem = onNavigateToItem,
                )
                Spacer(modifier = Modifier.padding(bottom = 10.dp))
            }
        }
    }
}


@Composable
fun CardItem(
    item: Item,
    onNavigateToItem: () -> Unit,
) {
    val paddingBottom = 30.dp
    val paddingTop = 15.dp
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(150.dp, 170.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(item.photo),
                contentDescription = "comfort",
                contentScale = ContentScale.FillBounds,
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(bottom = paddingBottom, top = paddingTop),
                    text = item.city,
                )
                Text(
                    modifier = Modifier.padding(bottom = paddingBottom),
                    text = item.type,
                    fontWeight = FontWeight.Light,
                )
                FilledTonalButton(
                    modifier = Modifier
                        .size(width = 150.dp, height = 70.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = onNavigateToItem,
                ) {
                    Text(
                        text = "Бронировать",
                    )
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
    photo = R.drawable.dzhubga,
    city = "город",
    type = "тип",
)
