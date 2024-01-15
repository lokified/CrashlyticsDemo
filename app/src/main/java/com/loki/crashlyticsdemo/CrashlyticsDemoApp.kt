package com.loki.crashlyticsdemo

import android.app.Application
import timber.log.Timber

class CrashlyticsDemoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber()  = when {
        BuildConfig.DEBUG -> {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
        else -> {
            Timber.plant(CrashlyticsTree())
        }
    }
}