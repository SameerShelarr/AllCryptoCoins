package com.sameershelar.allcryptocoins.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val id: String = "",
    val name: String = "",
    @SerialName("coin_counter")
    val coinCounter: Int = 0,
    @SerialName("ico_counter")
    val icoCounter: Int = 0,
)