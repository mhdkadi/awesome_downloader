package com.mhdkadi.awesome_downloader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NotificationEventsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val event = intent?.getStringExtra("ACTION")
        if (event != null) {
            Log.i("onReceive","$event")
        }else{
            Log.i("onReceive","NULL")
        }
    }
}