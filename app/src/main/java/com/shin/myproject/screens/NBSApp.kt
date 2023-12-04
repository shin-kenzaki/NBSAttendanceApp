
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.shin.myproject.ViewModel.ScreenViewModel
import com.shin.myproject.navigation.routes.AuthRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.screens.authenticationScreens.login.screen.LoginScreen
import com.shin.myproject.screens.authenticationScreens.otp.OTPScreen
import com.shin.myproject.screens.authenticationScreens.register.screen.RegistrationScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NBSApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination =  Routes.AUTH.name)  {
//        composable(route = Routes.SPLASH.name) {
//            SplashScreen(navController, screenViewModel)
//        }
        composable(route = Routes.MAIN.name ) {
            MainScreen(navController)
        }
        navigation(startDestination = AuthRoute.LoginScreen.name, route = Routes.AUTH.name) {
            composable(route = AuthRoute.LoginScreen.name) {
                LoginScreen(navController)
            }
            composable(route = AuthRoute.RegistrationScreen.name) {
                RegistrationScreen(navController)
            }
            composable(route = AuthRoute.OTPScreen.name) {
                OTPScreen(navController)
            }
        }
    }
}
