package com.sameershelar.allcryptocoins

import android.app.Application
import com.sameershelar.allcryptocoins.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AllCryptoCoinsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            androidContext(this@AllCryptoCoinsApplication)
            modules(commonModule)
        }
    }
}