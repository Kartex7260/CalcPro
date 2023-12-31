package kanti.calcpro

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kanti.calcpro.ui.screen.calculator.CalculatorScreen

@Composable
fun CalcNavHost() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = Const.NavDestinations.Calculator
	) {
		composable(
			route = Const.NavDestinations.Calculator
		) {
			CalculatorScreen()
		}
	}
}