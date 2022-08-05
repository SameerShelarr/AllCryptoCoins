package com.sameershelar.allcryptocoins

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
    fun onClear()
}