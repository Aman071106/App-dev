import 'dart:developer';

import 'package:flutter/material.dart';
//geolocator
import 'package:geolocator/geolocator.dart';
import 'package:fluttertoast/fluttertoast.dart';

class GeoLocator extends StatefulWidget {
  const GeoLocator({super.key});

  @override
  createState() => _Stateobj();
}

class _Stateobj extends State<GeoLocator> {
  //--State Building-- and functions
  Position? _pos;
  LocationPermission? _permission;
  Future<void> fetchLocation() async {
    //required checks before fetching
    log(_permission.toString());
    if (_permission == null || _permission == LocationPermission.denied) {
      log("here 3");
      _permission = await Geolocator.requestPermission();
    }
    if (_permission == LocationPermission.deniedForever) {
      log("always denied in settings or never");
      Fluttertoast.showToast(msg: "Permission Denied Forever");
      return;
    }

    if (_permission == LocationPermission.denied) {
      log("here 4");
      Fluttertoast.showToast(msg: "Permission Denied");
      return;
    }

    bool serviceEnabled = await Geolocator
        .isLocationServiceEnabled(); //location enabled by user or not
    if (!serviceEnabled) {
      Fluttertoast.showToast(msg: "Turn on Location");
      return;
    }
    Position current = await Geolocator.getCurrentPosition();
    setState(() {
      _pos = current;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("GeoLocator"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(
                onPressed: () async {
                  fetchLocation();
                },
                style: ButtonStyle(
                    backgroundColor: WidgetStatePropertyAll(Colors.white),
                    elevation: WidgetStatePropertyAll(20),
                    shape: WidgetStatePropertyAll(RoundedRectangleBorder(
                        borderRadius: BorderRadius.all(Radius.zero)))),
                child: Text(
                  "Get Location",
                  style: TextStyle(color: Colors.blue),
                )),
            Text(
              _pos == null ? "Location" : _pos.toString(),
            )
          ],
        ),
      ),
    );
  }
}
