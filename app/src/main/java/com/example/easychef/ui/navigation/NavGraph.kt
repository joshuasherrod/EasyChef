package com.example.easychef.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.easychef.ui.features.loginscreen.LoginScreen
import com.example.easychef.ui.features.home.HomeScreen
import com.example.easychef.ui.features.pantry.PantryScreen

// Alias route classes to avoid name clashes with composables
import com.example.easychef.ui.navigation.LoginScreen as LoginScreenRoute
import com.example.easychef.ui.navigation.HomeScreen as HomeScreenRoute
import com.example.easychef.ui.navigation.Preferences as PreferencesRoute
import com.example.easychef.ui.navigation.Pantry as PantryRoute

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = LoginScreenRoute
    ) {

        // LOGIN — pass the callbacks that LoginScreen expects
        composable<LoginScreenRoute> {
            LoginScreen(
                onGoToHome = { id ->
                    navController.navigate(HomeScreenRoute(id))     // fixes: “Cannot infer value parameter 'id'”
                },
                onGoToPreferenceScreen = { id ->
                    navController.navigate(PreferencesRoute(id))
                }
            )
        }

        // HOME — provide the new pantry callback
        composable<HomeScreenRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<HomeScreenRoute>()
            HomeScreen(
                id = args.id,
                onGoToPantry = { navController.navigate(PantryRoute) }
            )
        }

        // PREFERENCES — it requires onGoToHome(String)
        composable<PreferencesRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<PreferencesRoute>()
            com.example.easychef.ui.features.preferences.Preferences(
                id = args.id,
                onGoToHome = { id -> navController.navigate(HomeScreenRoute(id)) }
            )
        }

        // PANTRY — simple destination
        composable<PantryRoute> {
            PantryScreen()
        }
    }
}
