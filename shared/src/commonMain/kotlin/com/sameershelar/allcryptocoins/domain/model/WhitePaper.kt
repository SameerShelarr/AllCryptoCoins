package com.sameershelar.allcryptocoins.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WhitePaper(
    val link: String = "",
    val thumbnail: String = ""
)