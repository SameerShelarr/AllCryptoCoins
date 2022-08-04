package com.sameershelar.allcryptocoins.di

import com.sameershelar.allcryptocoins.presentation.crypto_coin_detail.CryptoCoinDetailViewModel
import com.sameershelar.allcryptocoins.presentation.crypto_coin_list.CryptoCoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {

    singleOf(::CryptoCoinListViewModel)

    viewModelOf(::CryptoCoinDetailViewModel)
}