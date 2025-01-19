import 'dart:developer';

import 'package:flutter/material.dart';
//picking
import 'package:image_picker/image_picker.dart';
import 'dart:io';

class ImPicker extends StatefulWidget {
  const ImPicker({super.key});

  @override
  createState() => _ImPickerState();
}

class _ImPickerState extends State<ImPicker> {
  //picker
  final ImagePicker _myImagePicker = ImagePicker();
  //--------------XFile File---------------
  XFile? _file; //mutltiplatform file

  Future<void> pick() async {
    final XFile? file =
        await _myImagePicker.pickImage(source: ImageSource.gallery);
    setState(() {
      _file = file;
    });
    log("image Picked ");
    if (_file != null) {
      log(_file!.path);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ImagePicker'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              padding: EdgeInsets.all(0),
              height: 300,
              width: double.infinity,
              color: Colors.grey.shade50,
              child: Center(
                  child: _file == null
                      ? Text(
                          "Image not Provided",
                          style: TextStyle(color: Colors.black),
                        )
                      : Image.file(
                          File(_file!.path),
                          fit: BoxFit.cover,
                        )),
            ),
            ElevatedButton(
              onPressed: () async {
                pick();
              },
              style: ButtonStyle(
                backgroundColor: WidgetStatePropertyAll(Colors.white),
                shape: WidgetStatePropertyAll(RoundedRectangleBorder(
                    borderRadius: BorderRadius.all(Radius.zero))),
              ),
              child: Text(
                "Provide Image",
                style: TextStyle(color: Colors.black),
              ),
            ),
            ElevatedButton(
              onPressed: () async {
                final List<XFile> images =
                    await _myImagePicker.pickMultiImage();
                log("images picked");
                if (images.isEmpty) {
                  log('no image');
                } else {
                  for (int i = 0; i < images.length; i++) {
                    log(images[i].path);
                  }
                }
              },
              style: ButtonStyle(
                backgroundColor: WidgetStatePropertyAll(Colors.white),
                shape: WidgetStatePropertyAll(RoundedRectangleBorder(
                    borderRadius: BorderRadius.all(Radius.zero))),
              ),
              child: Text(
                "Provide Images",
                style: TextStyle(color: Colors.black),
              ),
            ),
            ElevatedButton(
              onPressed: () async {
                final im =
                    await _myImagePicker.pickImage(source: ImageSource.camera);
                setState(() {
                  _file = im;
                });
              },
              style: ButtonStyle(
                backgroundColor: WidgetStatePropertyAll(Colors.white),
                shape: WidgetStatePropertyAll(RoundedRectangleBorder(
                    borderRadius: BorderRadius.all(Radius.zero))),
              ),
              child: Text(
                "Provide Image",
                style: TextStyle(color: Colors.black),
              ),
            )
          ],
        ),
      ),
    );
  }
}
