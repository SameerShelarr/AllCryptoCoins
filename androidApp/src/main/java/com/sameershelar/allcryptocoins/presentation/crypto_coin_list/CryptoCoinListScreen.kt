package com.sameershelar.allcryptocoins.presentation.crypto_coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sameershelar.allcryptocoins.presentation.Screen
import com.sameershelar.allcryptocoins.presentation.crypto_coin_list.composables.CryptoCoinListItem
import org.koin.androidx.compose.get

@Composable
fun CryptoCoinListScreen(
    navController: NavController,
    viewModel: CryptoCoinListViewModel = get(),
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.cryptoCoins) { cryptoCoin ->
                CryptoCoinListItem(cryptoCoin = cryptoCoin, onItemClick = {
                    navController.navigate(
                        route = Screen.CryptoCoinDetailScreen.route + "/${cryptoCoin.id}"
                    )
                })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center),
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}