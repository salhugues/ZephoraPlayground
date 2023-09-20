package com.salhugues.zephoraplayground

import android.app.Application
import com.salhugues.zephoraplayground.di.ZephoraDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ZephoraApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ZephoraApplication)
            modules(ZephoraDI.loadModules())
        }
    }
}
