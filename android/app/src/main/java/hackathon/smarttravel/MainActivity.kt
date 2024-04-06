package hackathon.smarttravel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yandex.mapkit.MapKitFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey(getString(R.string.MAPKIT_API_KEY))
        MapKitFactory.initialize(this)
        MapKitFactory.getInstance().onStart()

        setContent {
            SmartTravelApp()
        }
    }
}
