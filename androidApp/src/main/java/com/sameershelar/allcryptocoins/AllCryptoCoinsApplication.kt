package com.sameershelar.allcryptocoins

import android.app.Application
import android.content.Context
import com.sameershelar.allcryptocoins.di.initKoin
import org.koin.dsl.module

class AllCryptoCoinsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module { single<Context>{this@AllCryptoCoinsApplication} }
        )
    }
}