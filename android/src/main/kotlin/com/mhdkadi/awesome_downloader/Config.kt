package com.mhdkadi.awesome_downloader
import android.content.Context
import android.content.SharedPreferences

public class Config(context:Context ) {
    private val  pref: SharedPreferences =context.getSharedPreferences("id.flutter.awesome_downloader", Context.MODE_PRIVATE)

    fun isAutoStartOnBoot(): Boolean {
        return pref.getBoolean("auto_start_on_boot", true)
    }
    fun setAutoStartOnBoot(value: Boolean) {
        pref.edit()
            .putBoolean("auto_start_on_boot", value)
            .apply()
    }
}