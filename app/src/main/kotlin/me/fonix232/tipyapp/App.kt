package me.fonix232.tipyapp

import android.app.Application
import net.danlew.android.joda.JodaTimeAndroid
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        JodaTimeAndroid.init(this)
        startKoin(this, listOf(dbModule, networkModule, clientModule, appModule))
    }
}