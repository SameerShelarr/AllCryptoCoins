package com.sameershelar.allcryptocoins.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    val url: String = "",
    val type: String = "",
    val stats: Stats? = null,
)