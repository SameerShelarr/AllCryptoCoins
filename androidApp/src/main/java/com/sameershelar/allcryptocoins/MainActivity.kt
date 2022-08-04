package com.sameershelar.allcryptocoins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sameershelar.allcryptocoins.presentation.Screen
import com.sameershelar.allcryptocoins.presentation.crypto_coin_detail.CryptoCoinDetailScreen
import com.sameershelar.allcryptocoins.presentation.crypto_coin_list.CryptoCoinListScreen
import com.sameershelar.allcryptocoins.presentation.ui.theme.AllCryptoCoinsTheme
import com.sameershelar.allcryptocoins.common.Constants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllCryptoCoinsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CryptoCoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CryptoCoinListScreen.route
                        ) {
                            CryptoCoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CryptoCoinDetailScreen.route + "/{${Constants.KEY_CRYPTO_COIN_ID}}"
                        ) {
                            CryptoCoinDetailScreen(
                                navController,
                                it.arguments?.getString(Constants.KEY_CRYPTO_COIN_ID) ?: ""
                            )
                        }
                    }
                }
            }
        }
    }
}
