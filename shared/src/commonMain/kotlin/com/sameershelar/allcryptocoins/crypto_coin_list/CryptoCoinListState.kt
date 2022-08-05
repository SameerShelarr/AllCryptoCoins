package com.sameershelar.allcryptocoins.crypto_coin_list

import com.sameershelar.allcryptocoins.domain.model.CryptoCoin

data class CryptoCoinListState(
    val isLoading: Boolean = false,
    val cryptoCoins: List<CryptoCoin> = emptyList(),
    val error: String = "",
)