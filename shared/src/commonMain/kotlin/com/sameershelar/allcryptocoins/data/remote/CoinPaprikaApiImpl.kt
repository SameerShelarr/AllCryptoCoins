package com.sameershelar.allcryptocoins.data.remote

import com.sameershelar.allcryptocoins.common.Constants
import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDto
import com.sameershelar.allcryptocoins.domain.remote.ICoinPaprikaAPI
import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDetailDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CoinPaprikaApiImpl constructor(
    private val client: HttpClient
)  : ICoinPaprikaAPI {

    override suspend fun getCryptoCoins(): List<CryptoCoinDto> {
        return client.get { url(Constants.GET_COINS_URL) }.body()
    }

    override suspend fun getCryptoCoinById(cryptoCoinId: String): CryptoCoinDetailDto {
        return client.get { url(Constants.GET_COINS_URL + "/$cryptoCoinId") }.body()
    }
}