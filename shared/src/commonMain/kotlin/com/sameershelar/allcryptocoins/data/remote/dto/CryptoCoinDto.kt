package com.sameershelar.allcryptocoins.data.remote.dto

import com.sameershelar.allcryptocoins.domain.model.CryptoCoin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCoinDto(
    val id: String = "",
    val name: String = "",
    val symbol: String = "",
    val rank: Int = 0,
    @SerialName("is_new")
    val isNew: Boolean = false,
    @SerialName("is_active")
    val isActive: Boolean = false,
    val type: String = ""
)

fun CryptoCoinDto.toCryptoCoin() = CryptoCoin(id, name, symbol, rank, isNew, isActive, type)