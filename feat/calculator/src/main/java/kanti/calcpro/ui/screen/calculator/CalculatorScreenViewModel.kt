package kanti.calcpro.ui.screen.calculator

import com.notkamui.keval.Keval
import com.notkamui.keval.KevalInvalidExpressionException
import com.notkamui.keval.KevalInvalidSymbolException
import com.notkamui.keval.KevalZeroDivisionException
import kanti.calcpro.core.CalcElement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.StringBuilder

interface CalculatorScreenViewModel {

	val result: StateFlow<CalculationUiState>

	val formula: StateFlow<FormulationUiState>

	fun append(element: CalcElement)

	fun remove()

	fun clear()

	companion object : CalculatorScreenViewModel {

		private val sb = StringBuilder()

		private val _result = MutableStateFlow<CalculationUiState>(CalculationUiState.Empty)
		private val _formula = MutableStateFlow<FormulationUiState>(FormulationUiState.Empty)

		override val result = _result.asStateFlow()
		override val formula = _formula.asStateFlow()

		override fun append(element: CalcElement) {
			sb.append(element.char)
			eval()
		}

		override fun remove() {
			val length = sb.length
			if (length > 0) {
				sb.deleteAt(index = length - 1)
			}
			eval()
		}

		override fun clear() {
			sb.clear()
			eval()
		}

		private fun eval() {
			if (sb.isEmpty()) {
				_formula.value = FormulationUiState.Empty
				_result.value = CalculationUiState.Empty
				return
			}

			val formula = sb.toString()
			_formula.value = FormulationUiState.Success(formula)

			try {
				val evalResult = Keval.eval(formula)
				_result.value = CalculationUiState.Success(evalResult)
			} catch (ex: KevalInvalidSymbolException) {
				_result.value = CalculationUiState.InvalidSymbol(ex.invalidSymbol)
			} catch (ex: KevalInvalidExpressionException) {
				_result.value = CalculationUiState.InvalidExpression(ex.expression)
			} catch (ex: KevalZeroDivisionException) {
				_result.value = CalculationUiState.ZeroDivision
			}
		}
	}
}