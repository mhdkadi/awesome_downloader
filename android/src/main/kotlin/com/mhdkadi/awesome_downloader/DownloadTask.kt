package com.mhdkadi.awesome_downloader

import org.json.JSONObject

data class DownloadTask(val jsonObject: JSONObject){
    val id=jsonObject.getString("id")
    val fileUrl=jsonObject.getString("fileUrl")
    val savingPath=jsonObject.getString("savingPath")
    val fileName =
        if (jsonObject.isNull("fileName")) null else jsonObject.getString("fileName")
    val notificationBody=
        if (jsonObject.isNull("notificationBody")) null else jsonObject.getString("notificationBody")

    val notificationTitle =
        if (jsonObject.isNull("notificationTitle")) null else jsonObject.getString("notificationTitle")
    val payload =
        if (jsonObject.isNull("payload")) null else jsonObject.getJSONObject("payload")
    val showNotification=jsonObject.getBoolean("showNotification")
    val updateServiceNotification=jsonObject.getBoolean("updateServiceNotification")
    val downloadTaskStatus=jsonObject.getString("downloadTaskStatus")
    val createdAt=jsonObject.getString("createdAt")
}
