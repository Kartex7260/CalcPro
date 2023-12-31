package kanti.calcpro.ui.screen.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notkamui.keval.Keval
import com.notkamui.keval.KevalInvalidExpressionException
import com.notkamui.keval.KevalInvalidSymbolException
import com.notkamui.keval.KevalZeroDivisionException
import dagger.hilt.android.lifecycle.HiltViewModel
import kanti.calcpro.core.CalcElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CalculatorScreenViewModelImpl @Inject constructor(
	private val keval: Keval
) : ViewModel(), CalculatorScreenViewModel {

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
			sb.deleteAt(index = sb.length - 1)
		}
		eval()
	}

	override fun clear() {
		sb.clear()
		eval()
	}

	private fun eval() {
		viewModelScope.launch {
			if (sb.isEmpty()) {
				_formula.value = FormulationUiState.Empty
				_result.value = CalculationUiState.Empty
				return@launch
			}

			withContext(Dispatchers.Default) {
				val formula = sb.toString()
				_formula.value = FormulationUiState.Success(formula)

				try {
					val evalResult = keval.eval(formula)
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
}