package com.sameershelar.allcryptocoins.presentation.crypto_coin_list.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sameershelar.allcryptocoins.presentation.ui.theme.CryptoOrangeLight
import com.sameershelar.allcryptocoins.presentation.ui.theme.CryptoOrangeLighter

@Composable
fun ListingChip(text: String) {
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = CryptoOrangeLight,
            shape = CircleShape
        )
    ) {
        Text(
            text = text, modifier = Modifier
                .padding(5.dp)
                .align(
                    Alignment.Center
                ),
            style = TextStyle(fontSize = 11.sp),
            color = CryptoOrangeLighter
        )
    }
}