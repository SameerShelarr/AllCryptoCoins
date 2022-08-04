package com.sameershelar.allcryptocoins.domain.usecase.get_cryptos

import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.data.remote.dto.toCryptoCoin
import com.sameershelar.allcryptocoins.domain.model.CryptoCoin
import com.sameershelar.allcryptocoins.domain.repository.ICryptoCoinRepository
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCryptoCoinsFromApiUseCase constructor(
    private val repository: ICryptoCoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CryptoCoin>>> = flow {
        emit(Resource.Loading())
        try {
            val cryptoCoins = repository.getAllCryptoCoins().map { it.toCryptoCoin() }
            emit(Resource.Success(cryptoCoins))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Unknown error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Unable to connect to the server!"))
        }
    }
}