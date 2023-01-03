import 'package:awesome_downloader/models/download_task.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'awesome_downloader_platform_interface.dart';

/// An implementation of [AwesomeDownloaderPlatform] that uses method channels.
class MethodChannelAwesomeDownloader extends AwesomeDownloaderPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('awesome_downloader');


  @override
  Future<String?> startBackgroundService() async {
    final version =
        await methodChannel.invokeMethod<String>('startBackgroundService');
    return version;
  }

  @override
  Future<String?> stopService() async {
    final version = await methodChannel.invokeMethod<String>('stopService');
    return version;
  }

  @override
  Future<String?> download(DownloadTask downloadTask) async {
    await methodChannel.invokeMethod<String>('download', downloadTask.toMap());
    return null;
  }
}
