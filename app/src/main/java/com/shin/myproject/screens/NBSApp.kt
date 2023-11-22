
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.shin.myproject.ViewModel.ScreenViewModel
import com.shin.myproject.navigation.routes.AuthRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.screens.SplashScreen
import com.shin.myproject.screens.authenticationScreens.login.screen.LoggedInSplash
import com.shin.myproject.screens.authenticationScreens.login.screen.LoginScreen
import com.shin.myproject.screens.authenticationScreens.otp.screen.OTPScreen
import com.shin.myproject.screens.authenticationScreens.register.screen.RegisterScreen
import com.shin.myproject.screens.authenticationScreens.register.screen.RegisteredSplash

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NBSApp(
    screenViewModel: ScreenViewModel,
) {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination =  Routes.SPLASH.name) {
        composable(route = Routes.SPLASH.name) {
            SplashScreen(navController, screenViewModel)
        }
        composable(route = Routes.LOGINSPLASH.name) {
            LoggedInSplash(navController, screenViewModel)
        }
        composable(route = Routes.REGISTERSPLASH.name) {
            RegisteredSplash(navController, screenViewModel)
        }
        composable(route = Routes.MAIN.name ) {
            MainScreen(navController, screenViewModel)
        }
        navigation(startDestination = AuthRoute.LoginScreen.name, route = Routes.AUTH.name) {
            composable(route = AuthRoute.LoginScreen.name) {
                LoginScreen(navController)
            }
            composable(route = AuthRoute.RegistrationScreen.name) {
                RegisterScreen(navController)
            }
            composable(route = AuthRoute.OTPScreen.name) {
                OTPScreen(navController)
            }
        }
    }
}
