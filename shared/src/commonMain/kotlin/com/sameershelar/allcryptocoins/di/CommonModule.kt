package com.sameershelar.allcryptocoins.di

import com.sameershelar.allcryptocoins.domain.remote.ICoinPaprikaAPI
import com.sameershelar.allcryptocoins.domain.repository.ICryptoCoinRepository
import com.sameershelar.allcryptocoins.domain.usecase.get_crypto.GetCryptoCoinDetailFromApiUseCase
import com.sameershelar.allcryptocoins.domain.usecase.get_cryptos.GetCryptoCoinsFromApiUseCase
import com.sameershelar.allcryptocoins.data.remote.CoinPaprikaApiImpl
import com.sameershelar.allcryptocoins.data.repository.CryptoCoinRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {

    singleOf<HttpClient> {
        HttpClient(CIO) {
            install(HttpTimeout) {
                requestTimeoutMillis = 60000
            }
            install(Logging) {
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }
                )
            }
        }
    }

    factoryOf(::GetCryptoCoinsFromApiUseCase)

    factoryOf(::GetCryptoCoinDetailFromApiUseCase)

    singleOf(::CoinPaprikaApiImpl) { bind<ICoinPaprikaAPI>() }

    singleOf(::CryptoCoinRepositoryImpl) { bind<ICryptoCoinRepository>() }
}