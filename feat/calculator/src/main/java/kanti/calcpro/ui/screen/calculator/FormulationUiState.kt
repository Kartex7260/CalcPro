package kanti.calcpro.ui.screen.calculator

sealed class FormulationUiState {

	data object Empty : FormulationUiState()

	data class Success(
		val formula: String
	) : FormulationUiState()
}