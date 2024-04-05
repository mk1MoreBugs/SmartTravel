package hackathon.okrugyuga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                Column {
                    
                    AndroidView(
                        modifier = Modifier.size(400.dp),
                        factory = {

                        MapView(it)
                        }
                    )

                }
            }
        }
    }
}
