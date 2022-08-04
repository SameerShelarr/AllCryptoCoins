package com.sameershelar.allcryptocoins.presentation.common_composables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.sameershelar.allcryptocoins.domain.model.CryptoCoinDetail
import com.sameershelar.allcryptocoins.presentation.ui.theme.CryptoAppBarDark
import com.sameershelar.allcryptocoins.presentation.ui.theme.CryptoAppBarLight

@Composable
fun CryptoAppBar(
    cryptoCoinDetail: CryptoCoinDetail? = null,
    content: @Composable (PaddingValues) -> Unit,
    onBackArrowClick: (() -> Unit)? = null,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "${cryptoCoinDetail?.name} (${cryptoCoinDetail?.symbol})") },
                backgroundColor = if (isSystemInDarkTheme()) CryptoAppBarDark else CryptoAppBarLight,
                navigationIcon = {
                    IconButton(onClick = {
                        onBackArrowClick?.invoke()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                },
            )
        },
        content = content
    )
}