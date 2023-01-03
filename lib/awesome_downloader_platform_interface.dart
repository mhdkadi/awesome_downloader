import 'package:awesome_downloader/models/download_task.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'awesome_downloader_method_channel.dart';

abstract class AwesomeDownloaderPlatform extends PlatformInterface {
  /// Constructs a AwesomeDownloaderPlatform.
  AwesomeDownloaderPlatform() : super(token: _token);

  static final Object _token = Object();

  static AwesomeDownloaderPlatform _instance = MethodChannelAwesomeDownloader();

  /// The default instance of [AwesomeDownloaderPlatform] to use.
  ///
  /// Defaults to [MethodChannelAwesomeDownloader].
  static AwesomeDownloaderPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [AwesomeDownloaderPlatform] when
  /// they register themselves.
  static set instance(AwesomeDownloaderPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> startBackgroundService() {
    throw UnimplementedError(
        'startBackgroundService() has not been implemented.');
  }

  Future<String?> stopService() {
    throw UnimplementedError('stopService() has not been implemented.');
  }

  Future<String?> download(DownloadTask downloadTask) {
    throw UnimplementedError('download() has not been implemented.');
  }

  Future<String?> pause() {
    throw UnimplementedError('pause() has not been implemented.');
  }

  Future<String?> pauseAll() {
    throw UnimplementedError('pauseAll() has not been implemented.');
  }

  Future<String?> cancel() {
    throw UnimplementedError('cancel() has not been implemented.');
  }

  Future<String?> cancelAll() {
    throw UnimplementedError('cancelAll() has not been implemented.');
  }

  Future<String?> resume() {
    throw UnimplementedError('resume() has not been implemented.');
  }

  Future<String?> resumeAll() {
    throw UnimplementedError('resumeAll() has not been implemented.');
  }

  Future<String?> delete() {
    throw UnimplementedError('delete() has not been implemented.');
  }
}
