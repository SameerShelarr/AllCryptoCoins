package com.sameershelar.allcryptocoins.presentation

sealed class Screen(val route: String) {
    object CryptoCoinListScreen : Screen("crypto_coin_list_screen")
    object CryptoCoinDetailScreen : Screen("crypto_coin_detail_screen")
}
