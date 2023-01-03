#import "AwesomeDownloaderPlugin.h"
#if __has_include(<awesome_downloader/awesome_downloader-Swift.h>)
#import <awesome_downloader/awesome_downloader-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "awesome_downloader-Swift.h"
#endif

@implementation AwesomeDownloaderPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftAwesomeDownloaderPlugin registerWithRegistrar:registrar];
}
@end
