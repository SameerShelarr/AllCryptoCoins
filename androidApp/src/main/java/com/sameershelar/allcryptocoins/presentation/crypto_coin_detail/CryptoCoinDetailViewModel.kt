package com.sameershelar.allcryptocoins.presentation.crypto_coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sameershelar.allcryptocoins.common.Resource
import com.sameershelar.allcryptocoins.domain.usecase.get_crypto.GetCryptoCoinDetailFromApiUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CryptoCoinDetailViewModel constructor(
    private val getCryptoCoinDetailFromApiUseCase: GetCryptoCoinDetailFromApiUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CryptoCoinDetailState())
    val state: State<CryptoCoinDetailState> = _state

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
        }.launchIn(viewModelScope)
    }
}