package com.mhdkadi.awesome_downloader

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class NotificationService {
    @RequiresApi(Build.VERSION_CODES.Q)
     fun createNotificationChannel(notificationManager: NotificationManager){
        val foregroundChannel =NotificationChannel(
            Constants.FOREGROUND_NOTIFICATION_CHANNEL_ID,
            "Foreground Service",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(foregroundChannel)
    }
     fun createNotification(
        context: Context
    ): NotificationCompat.Builder {
        val flag =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                PendingIntent.FLAG_IMMUTABLE
            else
                0
        //notificationIntent
        val notificationIntent = Intent(context, AwesomeDownloaderPlugin::class.java)
        val notificationPendingIntent =
            PendingIntent.getActivity(context, 1234, notificationIntent, 0)
        //Pause All ACTION
        val pauseIntent = Intent(context, NotificationEventsReceiver::class.java).apply {
            putExtra("ACTION", "Pause All")
        }
        val pausePendingIntent = PendingIntent.getBroadcast(
            context,
            1235,
            pauseIntent,
            flag
        )//Start All ACTION
        val startIntent = Intent(context, NotificationEventsReceiver::class.java).apply {
            putExtra("ACTION", "Start All")
        }
        val startPendingIntent = PendingIntent.getBroadcast(
            context,
            1236,
            startIntent,
            flag
        )//Cancel All ACTION
        val cancelIntent = Intent(context, NotificationEventsReceiver::class.java).apply {
            putExtra("ACTION", "Cancel All")
        }
        val cancelPendingIntent = PendingIntent.getBroadcast(
            context,
            1237,
            cancelIntent,
            flag
        )
        return NotificationCompat.Builder(context, Constants.FOREGROUND_NOTIFICATION_CHANNEL_ID)
            .setContentIntent(notificationPendingIntent)
            .setOngoing(true)
            .setContentTitle("Content Title")
            .setContentText("Content Text")
            .setContentInfo("Content Info")
            .setSmallIcon(R.drawable.ic_baseline_arrow_downward_24)
            .addAction(R.drawable.ic_baseline_arrow_downward_24, "Pause All", pausePendingIntent)
            .addAction(R.drawable.ic_baseline_arrow_downward_24, "Start All", startPendingIntent)
            .addAction(R.drawable.ic_baseline_arrow_downward_24, "Cancel All", cancelPendingIntent)
    }
}