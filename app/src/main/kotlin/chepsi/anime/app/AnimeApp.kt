package chepsi.anime.app

import android.app.Application
import android.content.pm.ApplicationInfo
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AnimeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        plantDebugLogger()
    }

    private fun plantDebugLogger() {
        val isDebuggable = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
        if (isDebuggable) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
