package com.sameershelar.allcryptocoins.domain.remote

import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDetailDto
import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDto

interface ICoinPaprikaAPI {

    suspend fun getCryptoCoins(): List<CryptoCoinDto>

    suspend fun getCryptoCoinById(cryptoCoinId: String): CryptoCoinDetailDto
}