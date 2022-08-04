package com.sameershelar.allcryptocoins.domain.usecase.get_crypto

import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.data.remote.dto.toCryptoDetail
import com.sameershelar.allcryptocoins.domain.model.CryptoCoinDetail
import com.sameershelar.allcryptocoins.domain.repository.ICryptoCoinRepository
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCryptoCoinDetailFromApiUseCase constructor(
    private val repository: ICryptoCoinRepository
) {
    operator fun invoke(cryptoCoinId: String): Flow<Resource<CryptoCoinDetail>> = flow {
        emit(Resource.Loading())
        try {
            val cryptoCoinDetail = repository.getCryptoCoinById(cryptoCoinId).toCryptoDetail()
            emit(Resource.Success(cryptoCoinDetail))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message ?: "Unknown error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Unable to connect to the server!"))
        }
    }
}