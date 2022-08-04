package com.sameershelar.allcryptocoins.domain.repository

import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDetailDto
import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDto

interface ICryptoCoinRepository {
    suspend fun getAllCryptoCoins(): List<CryptoCoinDto>
    suspend fun getCryptoCoinById(cryptoCoinId: String): CryptoCoinDetailDto
}