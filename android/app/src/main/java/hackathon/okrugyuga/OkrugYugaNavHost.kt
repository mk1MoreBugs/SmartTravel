package hackathon.okrugyuga

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hackathon.okrugyuga.ui.booking.BookingScreen
import hackathon.okrugyuga.ui.home.HomeScreen

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val BOOKING_ROUTE = "booking_route"
}


@Composable
fun OkrugYugaNavHost(
    navController: NavHostController,
    startDestination: String,
    ) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen(
                onNavigateToItem = {
                    navController.navigate(MainDestinations.BOOKING_ROUTE)

                }
            )
        }
        composable(MainDestinations.BOOKING_ROUTE) {
            BookingScreen(
                onNavigateToHome = {
                    navController.navigate(MainDestinations.HOME_ROUTE) {
                        popUpTo(MainDestinations.BOOKING_ROUTE) {
                            inclusive = false
                        }
                    }
                }
            )

        }
    }


}