package com.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.calculator.sealeds.CalculatorAction
import com.calculator.sealeds.CalculatorOperation
import com.calculator.ui.theme.LightGray
import com.calculator.ui.theme.Orange

@Composable
fun CalculatorButtonRow(
    buttons: List<String>, buttonSpacing: Dp, onAction: (CalculatorAction) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        buttons.forEach { symbol ->
            val modifier = Modifier
                .background(
                    when {
                        symbol in setOf("AC", "Del") -> LightGray
                        symbol in setOf("/", "x", "-", "+", "=") -> Orange
                        symbol.toIntOrNull() != null || symbol == "." -> Color.DarkGray
                        else -> throw IllegalArgumentException("Unsupported symbol: $symbol")
                    }
                )
                .aspectRatio(1f)
                .weight(if (symbol in setOf("AC", "0")) 2f else 1f)

            CalculatorButton(symbol = symbol, modifier = modifier, onClick = {
                when (symbol) {
                    "AC" -> onAction(CalculatorAction.Clear)
                    "Del" -> onAction(CalculatorAction.Delete)
                    "/", "x", "-", "+" -> {
                        val operation = CalculatorOperation.fromSymbol(symbol)
                        operation?.let { onAction(CalculatorAction.Operation(it)) }
                    }

                    "=" -> onAction(CalculatorAction.Calculate)
                    else -> onAction(CalculatorAction.Number(symbol.toIntOrNull() ?: 0))
                }
            })
        }
    }
}
