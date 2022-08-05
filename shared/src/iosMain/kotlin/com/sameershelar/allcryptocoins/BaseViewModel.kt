package com.sameershelar.allcryptocoins

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual open class BaseViewModel {

    actual val scope: CoroutineScope = MainScope()

    actual fun onClear() {
        scope.cancel()
    }
}