package kanti.calcpro.ui.screen.calculator

sealed class CalculationUiState {

	data object Empty : CalculationUiState()

	data class Success(
		val value: Double
	) : CalculationUiState()

	data class InvalidSymbol(
		val invalidSymbol: String
	) : CalculationUiState()

	data class InvalidExpression(
		val expression: String
	) : CalculationUiState()

	data object ZeroDivision : CalculationUiState()
}
