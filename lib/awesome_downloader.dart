import 'awesome_downloader_platform_interface.dart';

class AwesomeDownloader {
  Future<String?> startBackgroundService() {
    return AwesomeDownloaderPlatform.instance.startBackgroundService();
  }

  Future<String?> stopService() {
    return AwesomeDownloaderPlatform.instance.stopService();
  }
}
