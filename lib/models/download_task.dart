class DownloadTask {
  DownloadTask._fromMap({
    required this.id,
    required this.fileUrl,
    required this.savingPath,
    required this.showNotification,
    required this.updateServiceNotification,
    required this.createdAt,
    required this.downloadTaskStatus,
    required this.progress,
    required this.size,
    this.fileName,
    this.notificationTitle,
    this.notificationBody,
    this.payload,
  });

  factory DownloadTask.fromMap(Map<String, dynamic> json) =>
      DownloadTask._fromMap(
        id: json["id"],
        fileUrl: json["fileUrl"],
        savingPath: json["savingPath"],
        fileName: json["fileName"],
        notificationBody: json["notificationBody"],
        notificationTitle: json["notificationTitle"],
        payload: json["payload"],
        showNotification: json["showNotification"],
        updateServiceNotification: json["updateServiceNotification"],
        createdAt: DateTime.parse(json["createdAt"]),
        downloadTaskStatus: DownloadTaskStatus.values
            .where((element) => element.name == json["downloadTaskStatus"])
            .first,
        progress: json["progress"],
        size: json["size"],
      );

  DownloadTask.newTask({
    required this.id,
    required this.fileUrl,
    required this.savingPath,
    this.fileName,
    this.notificationTitle,
    this.notificationBody,
    this.payload,
    this.showNotification = false,
    this.updateServiceNotification = true,
  })  : downloadTaskStatus = DownloadTaskStatus.pending,
        createdAt = DateTime.now(),
        progress = 0,
        size = "0 KB";

  final DateTime createdAt;
  final DownloadTaskStatus downloadTaskStatus;
  final String? fileName;
  final String fileUrl;
  final String id;
  final String? notificationBody;
  final String? notificationTitle;
  final Map<String, String>? payload;
  final int progress;
  final String savingPath;
  final bool showNotification;
  final String size;
  final bool updateServiceNotification;

  @override
  String toString() {
    return toMap().toString();
  }

  static List<DownloadTask> downloadTasks(List data) =>
      data.map((e) => DownloadTask.fromMap(e)).toList();

  Map<String, dynamic> toMap() {
    return {
      "id": id,
      "fileUrl": fileUrl,
      "savingPath": savingPath,
      "fileName": fileName,
      "notificationBody": notificationBody,
      "notificationTitle": notificationTitle,
      "payload": payload,
      "showNotification": showNotification,
      "updateServiceNotification": updateServiceNotification,
      "downloadTaskStatus": downloadTaskStatus.name,
      "createdAt": createdAt.toIso8601String(),
    };
  }
}

enum DownloadTaskStatus {
  pending,
  running,
  finished,
  paused,
  canceled,
  faield,
}
