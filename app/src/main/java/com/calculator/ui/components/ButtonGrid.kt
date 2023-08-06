package com.calculator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.calculator.sealeds.CalculatorAction

@Composable
fun ButtonGrid(
    rows: List<List<String>>,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp,
    onAction: (CalculatorAction) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        rows.forEach { row ->
            CalculatorButtonRow(row, buttonSpacing, onAction)
        }
    }
}