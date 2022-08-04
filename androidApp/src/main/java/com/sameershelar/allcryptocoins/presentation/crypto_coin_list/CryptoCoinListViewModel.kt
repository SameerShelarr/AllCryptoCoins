package com.sameershelar.allcryptocoins.presentation.crypto_coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.domain.usecase.get_cryptos.GetCryptoCoinsFromApiUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CryptoCoinListViewModel constructor(
    private val getCryptoCoinsFromApiUseCase: GetCryptoCoinsFromApiUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CryptoCoinListState())
    val state: State<CryptoCoinListState> = _state

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
        }.launchIn(viewModelScope)
    }
}