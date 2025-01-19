import 'dart:developer';

import 'package:flutter/material.dart';

class Alert_1 extends StatefulWidget {
  const Alert_1({super.key});
  @override
  createState() => Alert_1_s();
}

class Alert_1_s extends State<Alert_1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Alert Button'),
      ),
      body: Center(
        child: ElevatedButton(
            onPressed: () {
              log("pressed");
              _showAlert(context);
            },
            child: Text('press for alert')),
      ),
    );
  }
}

Future<void> _showAlert(BuildContext context) async {
  //?
  return showDialog(
      context: context,
      builder: (BuildContext context) {
        //?
        return AlertDialog(
          //without any content it shows a light black screen
          //cutomizations
          title: Text('ALERT'),
          icon: Icon(Icons.alarm),
          content: SingleChildScrollView(
            child: ListBody(
              children: [Text('This is a alert'), Text('Hey, This is a alert')],
            ),
          ),
          actions: <Widget>[
            //widget CAN ALSO BE REMOVED, IT signifies dtype of list
            TextButton(
              onPressed: () {
                log("mssg");
              },
              child: Text('action 1'),
            ),
            TextButton(
              onPressed: () {
                Navigator.of(context).pop(); //navigation
              },
              child: Text('action 2'),
            )
          ],
        );
      });
}






//1. Why is the _showAlert function a Future?
// The _showAlert function is asynchronous and returns a Future<void> because:

// showDialog is asynchronous: It waits for the user to interact with the dialog (e.g., by pressing a button) before completing.
// The dialog is essentially a "blocking operation" until the user responds, and the app needs to wait for the dialog interaction to complete. By marking the function as Future, it makes clear that it involves asynchronous operations.
// This allows you to handle further actions after the dialog is dismissed if needed. For example:

// dart
// Copy code
// await _showAlert(context);
// log("Dialog closed");
// Here, the code after await will only run after the dialog is dismissed.

// 2. Why use showDialog instead of directly returning the AlertDialog?
// showDialog provides the necessary infrastructure:
// It manages the dialog's lifecycle.
// It ensures the dialog appears on top of the current UI.
// It handles user interaction, such as tapping outside to dismiss the dialog or using the "Back" button.
// If you directly return the AlertDialog, it won’t work properly because Flutter wouldn’t know how to display it without showDialog to handle the rendering and placement.

// showDialog wraps the AlertDialog in a ModalRoute:
// This is what makes the dialog modal (i.e., it takes focus and blocks interaction with the rest of the app).
// 3. Why is BuildContext required?
// The BuildContext is essential in Flutter because:

// It provides access to the widget tree at the location where the dialog is being shown.
// showDialog uses the BuildContext to know where to insert the dialog in the widget tree. This ensures the dialog is shown above the current UI.
// Without BuildContext, the app wouldn’t know which part of the UI the dialog is associated with.
// When you call _showAlert(context), you pass the context of the widget that triggers the dialog. This is why context is a required parameter for functions like showDialog.

// Why not skip any of these steps?
// Skipping Future:
// You lose the ability to perform actions after the dialog is dismissed.
// Skipping showDialog:
// You lose modal functionality and proper dialog handling.
// Skipping BuildContext:
// The dialog can’t determine where to render itself in the widget tree.