package com.sameershelar.allcryptocoins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sameershelar.allcryptocoins.ui.theme.AllCryptoCoinsTheme

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AllCryptoCoinsTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(greet(), modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}
