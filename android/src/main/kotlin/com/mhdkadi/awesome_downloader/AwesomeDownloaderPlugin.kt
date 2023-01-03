package com.mhdkadi.awesome_downloader

import android.content.Context
import android.content.Intent
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import org.json.JSONObject





/** AwesomeDownloaderPlugin */
class AwesomeDownloaderPlugin: FlutterPlugin, MethodCallHandler {

  private lateinit var channel : MethodChannel
  private lateinit var context: Context

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    this.channel = MethodChannel(flutterPluginBinding.binaryMessenger, "awesome_downloader")
    this.context = flutterPluginBinding.applicationContext;
    this.channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    val method = call.method
    val arg = call.arguments as JSONObject
    val serviceIntent = Intent(context, ForegroundService::class.java)
    if (method.equals("startBackgroundService")) {
      ContextCompat.startForegroundService(context, serviceIntent)
      result.success("Android startBackgroundService");
    } else if (method.equals("stopService")) {
      context.stopService(serviceIntent)
      result.success("Android stopService")
    } else if (method.equals("download")) {
      val downloadTask =DownloadTask(arg)
      result.success("Android download")
    } else {
      result.notImplemented();
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}



