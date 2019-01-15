package me.fonix232.tipyapp.util

import android.content.SharedPreferences
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import java.util.concurrent.TimeUnit

class Synk : KoinComponent {
    private val preferences: SharedPreferences by inject()

    companion object {
        private const val SYNK_IT = true
        private const val DONT_SYNK = false
    }

    fun shouldSync(key: String, window: Int = 4, unit: TimeUnit = TimeUnit.HOURS): Boolean {
        val currentSavedValue = preferences.getString(key, "")

        if (currentSavedValue.isNullOrEmpty()) //Operation has never run or Synk doesn't know about it
            return syncIt(key)

        val syncedTime = DateTime.parse(currentSavedValue)
        val syncBlock = when (unit) { //Identify the block window from last sync
            TimeUnit.MINUTES -> syncedTime.plusMinutes(window)
            TimeUnit.HOURS -> syncedTime.plusHours(window)
            TimeUnit.DAYS -> syncedTime.plusDays(window)
            else -> throw IllegalStateException("Illegal time window")
        }

        //Is the current time past the sync block window?
        return if (DateTime.now() >= syncBlock) syncIt(key) else DONT_SYNK
    }

    fun syncSuccess(key: String) {
        saveSyncTime(key)
    }

    fun syncFailure(key: String) {
        preferences.edit()
            ?.remove(key)
            ?.apply()
    }

    private fun syncIt(key: String): Boolean {
        saveSyncTime(key)
        return SYNK_IT
    }

    private fun saveSyncTime(key: String, dateTime: DateTime = DateTime.now()) {
        preferences.edit()
            ?.putString(key, ISODateTimeFormat.dateTime().print(dateTime))
            ?.apply()
    }
}