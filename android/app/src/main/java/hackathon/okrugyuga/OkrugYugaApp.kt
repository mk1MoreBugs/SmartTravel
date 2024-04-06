package hackathon.okrugyuga

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import hackathon.okrugyuga.ui.theme.OkrugYugaTheme


@Composable
fun OkrugYugaApp() {
    OkrugYugaTheme {
        OkrugYugaNavHost(
            navController = rememberNavController(),
            startDestination = MainDestinations.HOME_ROUTE,
            )
    }
}