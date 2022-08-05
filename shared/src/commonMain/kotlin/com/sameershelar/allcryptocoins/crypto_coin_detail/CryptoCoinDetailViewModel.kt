package com.sameershelar.allcryptocoins.crypto_coin_detail

import com.sameershelar.allcryptocoins.BaseViewModel
import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.domain.usecase.get_crypto.GetCryptoCoinDetailFromApiUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CryptoCoinDetailViewModel constructor(
    private val getCryptoCoinDetailFromApiUseCase: GetCryptoCoinDetailFromApiUseCase,
) : BaseViewModel() {

    private val _state = MutableStateFlow(CryptoCoinDetailState())
    val state: StateFlow<CryptoCoinDetailState> = _state

    fun setCryptoCoinId(cryptoCoinId: String) {
        if (cryptoCoinId.isNotBlank()) {
            getCryptoCoinDetailFromApi(cryptoCoinId)
        } else {
            _state.value = CryptoCoinDetailState(error = "Unable to find the crypto coin detail!")
        }
    }

    private fun getCryptoCoinDetailFromApi(cryptoCoinId: String) {
        getCryptoCoinDetailFromApiUseCase(cryptoCoinId).onEach { result ->
            when (result) {
                is Resource.Loading -> _state.value = CryptoCoinDetailState(isLoading = true)
                is Resource.Success -> _state.value =
                    CryptoCoinDetailState(cryptoCoinDetail = result.data)
                is Resource.Error -> _state.value =
                    CryptoCoinDetailState(error = result.message ?: "Unknown error occurred")
            }
        }.launchIn(scope)
    }
}