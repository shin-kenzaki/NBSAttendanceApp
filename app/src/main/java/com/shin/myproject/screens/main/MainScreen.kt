
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.shin.myproject.ViewModel.ScreenViewModel
import com.shin.myproject.navigation.bottomNavBar.BottomNavBar
import com.shin.myproject.navigation.routes.MainRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.analyticDashboard.screen.DashboardScreen
import com.shin.myproject.screens.main.mainScreen.home.screen.HomeScreen
import com.shin.myproject.screens.main.mainScreen.notification.screen.NotificationScreen
import com.shin.myproject.screens.main.mainScreen.profile.screen.ProfileScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.SubjectMainScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.addsubjectscreen.SubjectAddScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
) {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(
                navController = navController,
                startDestination = MainRoute.HomeScreen.name
            ) {
                composable(route = MainRoute.HomeScreen.name) {
                    HomeScreen(navController)
                }
                composable(route = MainRoute.Dashboard.name) {
                    DashboardScreen(navController)
                }
                composable(route = MainRoute.Subjects.name) {
                    SubjectMainScreen(navController)
                }
                composable(route = SubjectRoute.SubjectMainScreen.name) {
                    SubjectAddScreen(navController)
                }
                navigation(
                    startDestination = SubjectRoute.SubjectMainScreen.name,
                    route = Routes.SUBJECTS.name
                ) {
                    composable(route = SubjectRoute.SubjectAddScreen.name) {
                        SubjectAddScreen(navController)
                    }
                }
                composable(route = MainRoute.Notifications.name) {
                    NotificationScreen(navController)
                }
                composable(route = MainRoute.Profile.name) {
                    ProfileScreen(navController)
                }
            }
        }
    }
}
