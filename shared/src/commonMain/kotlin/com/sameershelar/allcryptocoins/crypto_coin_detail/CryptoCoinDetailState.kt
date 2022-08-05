package com.sameershelar.allcryptocoins.crypto_coin_detail

import com.sameershelar.allcryptocoins.domain.model.CryptoCoinDetail

data class CryptoCoinDetailState(
    val isLoading: Boolean = false,
    val cryptoCoinDetail: CryptoCoinDetail? = null,
    val error: String = "",
)