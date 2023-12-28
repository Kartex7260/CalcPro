package kanti.calcpro.core

enum class CalcElement(
	val char: Char
) {

	ZERO(char = '0'),
	ONE(char = '1'),
	TWO(char = '2'),
	THREE(char = '3'),
	FOUR(char = '4'),
	FIVE(char = '5'),
	SIX(char = '6'),
	SEVEN(char = '7'),
	EIGHT(char = '8'),
	NINE(char = '9'),

	ADD(char = '+'),
	SUBTRACT(char = '-'),
	MULTIPLY(char = '*'),
	DIVIDE(char = '/'),

	COMMA(char = ',')
}