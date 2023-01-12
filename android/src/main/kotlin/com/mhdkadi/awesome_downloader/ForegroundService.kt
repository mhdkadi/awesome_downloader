package com.mhdkadi.awesome_downloader

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder

class ForegroundService : Service() {
    private val notificationService=NotificationService()
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationService.createNotificationChannel(notificationManager)

         }

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            val notification=notificationService.createNotification(this).build()
            startForeground(100,notification)
        return START_STICKY
    }
}