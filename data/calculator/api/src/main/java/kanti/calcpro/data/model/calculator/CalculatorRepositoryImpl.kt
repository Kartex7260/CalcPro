package kanti.calcpro.data.model.calculator

import com.notkamui.keval.Keval
import kanti.calcpro.core.CalcElement
import kanti.calcpro.core.CalcElementConverter
import kanti.calcpro.data.model.calculator.datasource.local.ElementLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CalculatorRepositoryImpl @Inject constructor(
	private val localDataSource: ElementLocalDataSource,
	private val keval: Keval,
	private val elementConverter: CalcElementConverter
) : CalculatorRepository {

	override val elements: Flow<List<CalcElement>>
		get() = localDataSource.elements

	override suspend fun pushElement(element: CalcElement) {
		localDataSource.pushElement(element)
	}

	override suspend fun popElement() {
		localDataSource.popElement()
	}

	override suspend fun clear() {
		localDataSource.clear()
	}

	override suspend fun compute(): Double {
		return coroutineScope {
			async(Dispatchers.Default) {
				val line = elementConverter.convert(localDataSource.getAll())
				keval.eval(line)
			}.await()
		}
	}
}