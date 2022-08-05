package com.sameershelar.allcryptocoins.crypto_coin_list

import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.domain.usecase.get_cryptos.GetCryptoCoinsFromApiUseCase
import com.sameershelar.allcryptocoins.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CryptoCoinListViewModel(
    private val getCryptoCoinsFromApiUseCase: GetCryptoCoinsFromApiUseCase
) : BaseViewModel() {

    private val _state = MutableStateFlow(CryptoCoinListState())
    val state: StateFlow<CryptoCoinListState> = _state

    init {
        getCryptoCoinsFromApi()
    }

    private fun getCryptoCoinsFromApi() {
        getCryptoCoinsFromApiUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> _state.value = CryptoCoinListState(isLoading = true)
                is Resource.Success -> _state.value =
                    CryptoCoinListState(cryptoCoins = result.data ?: emptyList())
                is Resource.Error -> _state.value =
                    CryptoCoinListState(error = result.message ?: "Unknown error occurred")
            }
        }.launchIn(scope)
    }
}