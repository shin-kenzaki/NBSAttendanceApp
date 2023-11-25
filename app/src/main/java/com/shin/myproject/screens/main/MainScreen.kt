
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.shin.myproject.ViewModel.SubjectViewModel
import com.shin.myproject.navigation.bottomNavBar.BottomNavBar
import com.shin.myproject.navigation.routes.MainRoute
import com.shin.myproject.navigation.routes.Routes
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.analyticDashboard.screen.DashboardScreen
import com.shin.myproject.screens.main.mainScreen.embeddedSubjects
import com.shin.myproject.screens.main.mainScreen.home.screen.HomeScreen
import com.shin.myproject.screens.main.mainScreen.notification.model.NotificationProvider
import com.shin.myproject.screens.main.mainScreen.notification.screen.NotificationScreen
import com.shin.myproject.screens.main.mainScreen.profile.screen.ProfileScreen
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
    val viewModel: SubjectViewModel = viewModel()
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
                    SubjectScreen(navController, viewModel)
                }
                navigation(startDestination = MainRoute.Subjects.name, route = Routes.SUBJECTS.name) {
                    composable(route = MainRoute.Subjects.name) {
                        SubjectScreen(navController, viewModel)
                    }
                    composable(route = SubjectRoute.Students.name) {
                        StudentScreen(navController, viewModel.selectedSubject)
                    }
                    composable(route = SubjectRoute.AddSubjectScreen.name) {
                        SubjectAddScreen(navController)
                    }
                    composable(route = SubjectRoute.AddStudentScreen.name) {
                        StudentAddScreen(navController)
                    }
                }
                composable(route = MainRoute.Notifications.name) {
                    val embeddedSubjects = embeddedSubjects()
                    val notifications = NotificationProvider.getNotificationsForSubjects(embeddedSubjects)
                    NotificationScreen(navController, notifications)
                }
                composable(route = MainRoute.Profile.name) {
                    ProfileScreen(navController)
                }
            }
        }
    }
}
