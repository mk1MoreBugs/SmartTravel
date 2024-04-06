package hackathon.okrugyuga

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView
import hackathon.okrugyuga.ui.theme.OkrugYugaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(getString(R.string.MAPKIT_API_KEY))
        MapKitFactory.initialize(this)
        MapKitFactory.getInstance().onStart()

        setContent {
            OkrugYugaTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val url =
                        "https://reservationsteps.ru/rooms/index/b7ed77bb-4b6d-4a74-84cc-b705afdc8976?lang=ru&colorSchemePreview=0&onlyrooms=&name=&surname=&email=&phone=&orderid=&servicemode=0&firstroom=0&vkapp=&insidePopup=0&dfrom=&dto=&adults=1"

                    AndroidView(
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
                }
            }
        }
    }
}
