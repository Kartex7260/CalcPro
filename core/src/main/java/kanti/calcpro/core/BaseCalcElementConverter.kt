package kanti.calcpro.core

class BaseCalcElementConverter : CalcElementConverter {

	override fun convert(elements: List<CalcElement>): String {
		val sb = StringBuilder()
		for (element in elements) {
			sb.append(element.char)
		}
		return sb.toString()
	}
}