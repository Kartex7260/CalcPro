package kanti.calcpro.ui.screen.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kanti.calcpro.ui.components.CalculatorPanel
import kanti.calcpro.ui.components.DeleteType

@Composable
fun CalculatorScreen(
	vm: CalculatorScreenViewModel = hiltViewModel<CalculatorScreenViewModelImpl>()
) {
	val result by vm.result.collectAsState()
	val formula by vm.formula.collectAsState()

	Scaffold(

	) { paddingValues ->
		Column(
			modifier = Modifier
				.padding(paddingValues)
		) {
			when (result) {
				is CalculationUiState.Success -> {
					Text(text = (result as CalculationUiState.Success).value.toString())
				}
				else -> {}
			}

			when (formula) {
				is FormulationUiState.Success -> {
					Text(text = (formula as FormulationUiState.Success).formula)
				}
				else -> {}
			}

			CalculatorPanel(
				onClick = {
					vm.append(it)
				},
				onDelete = {
					when (it) {
					   DeleteType.All -> vm.clear()
					   DeleteType.One -> vm.remove()
					}
				},
				onCalculation = {}
			)
		}
	}
}

@Preview
@Composable
fun PreviewCalculatorScreen() {
	CalculatorScreen(
		vm = CalculatorScreenViewModel
	)
}