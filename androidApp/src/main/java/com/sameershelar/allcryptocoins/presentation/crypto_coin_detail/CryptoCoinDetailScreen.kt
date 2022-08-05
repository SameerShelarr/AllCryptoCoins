package com.sameershelar.allcryptocoins.presentation.crypto_coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.sameershelar.allcryptocoins.crypto_coin_detail.CryptoCoinDetailViewModel
import com.sameershelar.allcryptocoins.presentation.common_composables.ActiveStatus
import com.sameershelar.allcryptocoins.presentation.common_composables.CryptoAppBar
import com.sameershelar.allcryptocoins.presentation.crypto_coin_detail.composables.CryptoCoinTag
import com.sameershelar.allcryptocoins.presentation.crypto_coin_detail.composables.TeamListItem
import org.koin.androidx.compose.get

@Composable
fun CryptoCoinDetailScreen(
    navController: NavController,
    cryptoCoinId: String = "",
    viewModel: CryptoCoinDetailViewModel = get(),
) {
    remember {
        viewModel.setCryptoCoinId(cryptoCoinId)
    }
    val state = viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.value.error.isNotBlank()) {
            Text(
                text = state.value.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Center)
            )
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }
    }

    state.value.cryptoCoinDetail?.let { cryptoCoinDetail ->
        CryptoAppBar(
            cryptoCoinDetail = cryptoCoinDetail,
            content = {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${cryptoCoinDetail.rank}. ${cryptoCoinDetail.name} (${cryptoCoinDetail.symbol})",
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier
                                    .weight(8f)
                                    .align(CenterVertically)
                            )
                            ActiveStatus(
                                isActive = cryptoCoinDetail.isActive,
                                modifier = Modifier.align(CenterVertically)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = cryptoCoinDetail.description.ifBlank { "No description" },
                            style = MaterialTheme.typography.body2
                        )
                        cryptoCoinDetail.tags?.let { tags ->
                            if (tags.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = "Tags",
                                    style = MaterialTheme.typography.h3
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                FlowRow(
                                    mainAxisSpacing = 10.dp,
                                    crossAxisSpacing = 10.dp,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    tags.forEach { tag ->
                                        CryptoCoinTag(tag = tag.name)
                                    }
                                }
                            }
                        }
                    }
                    cryptoCoinDetail.team.let { team ->
                        if (team.isNotEmpty()) {
                            item {
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = "Team Members",
                                    style = MaterialTheme.typography.h3
                                )
                            }
                            items(team) { teamMember ->
                                TeamListItem(
                                    name = teamMember.name,
                                    position = teamMember.position,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                )
                                Divider()
                            }
                        }
                    }
                }
            },
            onBackArrowClick = {
                navController.popBackStack()
            }
        )
    }
}