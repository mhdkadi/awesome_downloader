import 'dart:async';

import 'package:awesome_downloader/awesome_downloader.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  final _awesomeDownloaderPlugin = AwesomeDownloader();

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  Future<void> initPlatformState() async {


  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion\n'),
        ),
        floatingActionButton: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              FloatingActionButton(
                onPressed: () async {
                  await _awesomeDownloaderPlugin.startBackgroundService();
                },
                child: const Icon(Icons.play_circle),
              ),
              FloatingActionButton(
                onPressed: () async {
                  await _awesomeDownloaderPlugin.stopService();
                },
                child: const Icon(Icons.pause_circle),
              )
            ],
          ),
        ),
      ),
    );
  }
}
