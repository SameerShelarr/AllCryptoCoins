package com.sameershelar.allcryptocoins.presentation.common_composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ActiveStatus(isActive: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (isActive) Color.Green else Color.Red,
                shape = RectangleShape
            )
            .padding(4.dp)
    ) {
        Text(
            text = if (isActive) "Active" else "Inactive",
            color = if (isActive) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
        )
    }
}