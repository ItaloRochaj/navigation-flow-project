package br.com.treinamento.navegacaofluxotelas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.treinamento.navegacaofluxotelas.ui.screens.DetailScreen
import br.com.treinamento.navegacaofluxotelas.ui.screens.HomeScreen
import br.com.treinamento.navegacaofluxotelas.ui.screens.WelcomeScreen

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Home : Screen("home")
    object Detail : Screen("detail/{destinationId}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(onExploreClick = {
                navController.navigate(Screen.Home.route)
            })
        }
        composable(Screen.Home.route) {
            HomeScreen(onDestinationClick = { id ->
                navController.navigate(Screen.Detail.createRoute(id))
            })
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val destinationId = backStackEntry.arguments?.getInt("destinationId") ?: 0
            DetailScreen(
                destinationId = destinationId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
