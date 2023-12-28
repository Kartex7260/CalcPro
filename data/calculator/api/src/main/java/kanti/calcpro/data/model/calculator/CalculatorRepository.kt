package kanti.calcpro.data.model.calculator

import kanti.calcpro.core.CalcElement
import kotlinx.coroutines.flow.Flow

interface CalculatorRepository {

	val elements: Flow<List<CalcElement>>

	suspend fun pushElement(element: CalcElement)

	suspend fun popElement()

	suspend fun clear()

	suspend fun compute(): Double
}