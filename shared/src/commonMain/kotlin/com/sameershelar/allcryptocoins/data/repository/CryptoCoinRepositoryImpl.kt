package com.sameershelar.allcryptocoins.data.repository

import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDetailDto
import com.sameershelar.allcryptocoins.data.remote.dto.CryptoCoinDto
import com.sameershelar.allcryptocoins.domain.remote.ICoinPaprikaAPI
import com.sameershelar.allcryptocoins.domain.repository.ICryptoCoinRepository

class CryptoCoinRepositoryImpl constructor(
    private val api: ICoinPaprikaAPI
) : ICryptoCoinRepository {

    override suspend fun getAllCryptoCoins(): List<CryptoCoinDto> {
        return api.getCryptoCoins()
    }

    override suspend fun getCryptoCoinById(cryptoCoinId: String): CryptoCoinDetailDto =
        api.getCryptoCoinById(cryptoCoinId)
}