package hackathon.smarttravel

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import hackathon.smarttravel.ui.theme.OkrugYugaTheme


@Composable
fun SmartTravelApp() {
    OkrugYugaTheme {
        SmartTravelNavHost(
            navController = rememberNavController(),
            startDestination = MainDestinations.HOME_ROUTE,
            )
    }
}