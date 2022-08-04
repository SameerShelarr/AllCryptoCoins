package com.sameershelar.allcryptocoins.presentation.crypto_coin_list.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sameershelar.allcryptocoins.domain.model.CryptoCoin
import com.sameershelar.allcryptocoins.presentation.common_composables.ActiveStatus
import com.sameershelar.allcryptocoins.presentation.ui.theme.CryptoOrangeLighter

@Composable
fun CryptoCoinListItem(
    cryptoCoin: CryptoCoin,
    onItemClick: (CryptoCoin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(cryptoCoin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(85.dp)
                    .width(85.dp)
                    .background(
                        color = CryptoOrangeLighter,
                        shape = CircleShape
                    )
                    .padding(5.dp)
            ) {
                Text(
                    text = cryptoCoin.symbol,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(Center),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
            Column(modifier = Modifier.align(CenterVertically)) {
                Text(
                    text = cryptoCoin.name,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    ListingChip(text = "Rank: ${cryptoCoin.rank}")
                    Spacer(modifier = Modifier.width(4.dp))
                    ListingChip(text = cryptoCoin.type)
                }
            }
        }
        ActiveStatus(
            isActive = cryptoCoin.isActive,
            modifier = Modifier.align(CenterVertically)
        )
    }
}