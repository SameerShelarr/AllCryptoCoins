package com.sameershelar.allcryptocoins.data.remote.dto

import com.sameershelar.allcryptocoins.domain.model.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCoinDetailDto(
    val id: String = "",
    val name: String = "",
    val symbol: String = "",
    val rank: Int = 0,
    @SerialName("is_new")
    val isNew: Boolean = false,
    @SerialName("is_active")
    val isActive: Boolean = false,
    val type: String = "",
    val tags: List<Tag> = emptyList(),
    val team: List<TeamMember> = emptyList(),
    val description: String = "",
    val message: String = "",
    @SerialName("open_source")
    val openSource: Boolean = false,
    @SerialName("started_at")
    val startedAt: String = "",
    @SerialName("development_status")
    val developmentStatus: String = "",
    @SerialName("hardware_wallet")
    val hardwareWallet: Boolean = false,
    @SerialName("proof_type")
    val proofType: String = "",
    @SerialName("org_structure")
    val orgStructure: String = "",
    @SerialName("hash_algorithm")
    val hashAlgorithm: String = "",
    val links: Links? = null,
    @SerialName("links_extended")
    val linksExtended: List<LinksExtended> = emptyList(),
    @SerialName("whitepaper")
    val whitePaper: WhitePaper? = null,
    @SerialName("first_data_at")
    val firstDataAt: String = "",
    @SerialName("last_data_at")
    val lastDataAt: String = ""
)

fun CryptoCoinDetailDto.toCryptoDetail() = CryptoCoinDetail(
    id,
    name,
    symbol,
    rank,
    isNew,
    isActive,
    type,
    tags,
    team,
    description,
    message,
    startedAt,
)