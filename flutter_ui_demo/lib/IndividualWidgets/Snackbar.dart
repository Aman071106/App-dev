import 'package:flutter/material.dart';

class MySnackbar extends StatelessWidget {
  //Snackbar is a  keyword so dont use it
  const MySnackbar({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Snackbar'),
        ),
        body: Container(
            child: Center(
          child: ElevatedButton(
              onPressed: () {
                final snackBar = SnackBar(
                  //customizing the snack bar
                  behavior: SnackBarBehavior.floating,

                  duration: const Duration(seconds: 5),

                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.all(Radius.circular(10))),

                  action: SnackBarAction(
                      label: '❌', textColor: Colors.blue, onPressed: () {}),

                  content: Text('Error has been made'),
                );
                ScaffoldMessenger.of(context).showSnackBar((snackBar));
              },
              child: Text('Press')),
        )));
  }
}
