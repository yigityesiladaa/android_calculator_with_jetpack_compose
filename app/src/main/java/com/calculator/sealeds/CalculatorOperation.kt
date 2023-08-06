package com.calculator.sealeds

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")

    companion object {
        fun fromSymbol(symbol: String): CalculatorOperation? {
            return when (symbol) {
                "+" -> Add
                "-" -> Subtract
                "x" -> Multiply
                "/" -> Divide
                else -> null
            }
        }
    }
}