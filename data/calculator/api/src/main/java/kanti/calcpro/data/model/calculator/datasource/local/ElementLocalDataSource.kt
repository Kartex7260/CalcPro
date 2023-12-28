package kanti.calcpro.data.model.calculator.datasource.local

import kanti.calcpro.core.CalcElement
import kotlinx.coroutines.flow.Flow

interface ElementLocalDataSource {

	val elements: Flow<List<CalcElement>>

	suspend fun getAll(): List<CalcElement>

	suspend fun pushElement(element: CalcElement)

	suspend fun popElement()

	suspend fun clear()
}