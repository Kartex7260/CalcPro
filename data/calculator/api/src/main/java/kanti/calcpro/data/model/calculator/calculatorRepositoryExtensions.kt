package kanti.calcpro.data.model.calculator

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun CalculatorRepository.computeAndClear(): Double {
	val computeResult = compute()
	coroutineScope {
		launch(context = coroutineContext + NonCancellable) {
			clear()
		}
	}
	return computeResult
}