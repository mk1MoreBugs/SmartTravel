package hackathon.okrugyuga.ui.booking

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun BookingScreen(
    onNavigateToHome: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Button(
            modifier = Modifier.size(300.dp, 75.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = onNavigateToHome,
        ) {
            Text(text = "Закрыть")
        }
    }
}