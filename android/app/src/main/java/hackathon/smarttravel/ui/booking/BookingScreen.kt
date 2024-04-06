package hackathon.smarttravel.ui.booking

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun BookingScreen(
    onNavigateToHome: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
            val url =
                "https://reservationsteps.ru/rooms/index/b7ed77bb-4b6d-4a74-84cc-b705afdc8976?lang=ru&colorSchemePreview=0&onlyrooms=&name=&surname=&email=&phone=&orderid=&servicemode=0&firstroom=0&vkapp=&insidePopup=0&dfrom=&dto=&adults=1"

            AndroidView(
                modifier = Modifier.size(1000.dp),
                factory = {
                    WebView(it).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        this.settings.apply {
                            javaScriptEnabled = true
                        }
                        loadUrl(url)
                        webViewClient = WebViewClient()
                    }
                }
            )
        Button(
            modifier = Modifier
                .size(300.dp, 75.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            onClick = onNavigateToHome,
        ) {
            Text(text = "Закрыть")
        }
    }
}