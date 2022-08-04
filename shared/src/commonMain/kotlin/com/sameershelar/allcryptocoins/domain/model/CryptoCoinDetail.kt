package com.sameershelar.allcryptocoins.domain.model

data class CryptoCoinDetail(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
    val type: String,
    val tags: List<Tag>?,
    val team: List<TeamMember>,
    val description: String,
    val message: String,
    val startedAt: String,
)
