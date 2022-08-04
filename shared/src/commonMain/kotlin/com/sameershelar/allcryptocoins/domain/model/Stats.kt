package com.sameershelar.allcryptocoins.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val subscribers: Int = 0,
    val contributors: Int = 0,
    val stars: Int = 0,
    val followers: Int = 0,
)