
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.shin.myproject.navigation.bottomNavBar.BottomNavBar
import com.shin.myproject.navigation.routes.MainRoute
import com.shin.myproject.navigation.routes.ProfileRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.analyticDashboard.screen.DashboardScreen
import com.shin.myproject.screens.main.mainScreen.home.screen.HomeScreen
import com.shin.myproject.screens.main.mainScreen.notification.screen.NotificationScreen
import com.shin.myproject.screens.main.mainScreen.profile.screen.ProfileScreen
import com.shin.myproject.screens.main.mainScreen.profile.screen.ProfileSettings
import com.shin.myproject.screens.main.mainScreen.subject.screen.StudentScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.SubjectScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.StudentAddScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.SubjectAddScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController = navController) }
    ) {

        Box(modifier = Modifier.padding(it)) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            val currentRoute = navBackStackEntry?.destination?.route ?: MainRoute.HomeScreen.name

            // Extract the screen title based on the current route
            val currentScreenTitle = when (currentRoute) {
                MainRoute.HomeScreen.name -> "Home"
                MainRoute.Dashboard.name -> "Dashboard"
                MainRoute.Subjects.name -> "Subjects"
                MainRoute.Notifications.name -> "Notifications"
                MainRoute.Profile.name -> "Profile"
                else -> "Unknown"
            }

            // Set up your topAppBar with the dynamic title
            TopAppBar(
                title = {
                    Text(text = currentScreenTitle)
                }
            )
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
                    SubjectScreen(navController)
                }
                navigation(startDestination = MainRoute.Subjects.name, route = Routes.SUBJECTS.name) {
                    composable(route = MainRoute.Subjects.name) {
                        SubjectScreen(navController)
                    }
                    composable(route = SubjectRoute.StudentsScreen.name) {
                        StudentScreen(navController)//edit this
                    }
                    composable(route = SubjectRoute.AddSubjectScreen.name) {
                        SubjectAddScreen(navController)
                    }
                    composable(route = SubjectRoute.AddStudentScreen.name) {
                        StudentAddScreen(navController)
                    }
                }
                composable(route = MainRoute.Notifications.name) {
                    NotificationScreen(navController)
                }
                composable(route = MainRoute.Profile.name) {
                    ProfileScreen(navController)
                }
                navigation(startDestination = MainRoute.Profile.name, route = Routes.PROFILE.name) {
                    composable(route = MainRoute.Profile.name) {
                        ProfileScreen(navController)
                    }
                    composable(route = ProfileRoute.ProfileSettings.name) {
                        ProfileSettings(navController)
                    }
                }
            }
        }
    }
}