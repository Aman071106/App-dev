//imports
import 'package:flutter/material.dart';
import 'package:flutter_ui_demo/Clone%201/clone1.dart';
import 'package:flutter_ui_demo/Clone%201/clone2.dart';
import 'package:flutter_ui_demo/IndividualWidgets/AnimatedText.dart';

// import 'package:flutter_ui_demo/IndividualWidgets/QuickLinksPages.dart';

//for log
import 'dart:developer';

//used widgets imports
import 'package:flutter_ui_demo/IndividualWidgets/Rows_cols_wrap.dart';
import 'package:flutter_ui_demo/IndividualWidgets/Snackbar.dart';
import 'package:flutter_ui_demo/IndividualWidgets/TextButtonElevatedButton.dart';
import 'package:flutter_ui_demo/IndividualWidgets/alert.dart';
import 'package:flutter_ui_demo/IndividualWidgets/bottomSheet.dart';
import 'package:flutter_ui_demo/IndividualWidgets/container_sized.dart';
import 'package:flutter_ui_demo/IndividualWidgets/ListViewGridView.dart';
import 'package:flutter_ui_demo/IndividualWidgets/dissmisible.dart';
import 'package:flutter_ui_demo/IndividualWidgets/drawer.dart';
import 'package:flutter_ui_demo/IndividualWidgets/forms.dart';
import 'package:flutter_ui_demo/IndividualWidgets/image.dart';
import 'package:flutter_ui_demo/IndividualWidgets/bottomNavigation.dart';
import 'package:flutter_ui_demo/IndividualWidgets/imagePicker.dart';
import 'package:flutter_ui_demo/IndividualWidgets/stack.dart';
import 'package:flutter_ui_demo/IndividualWidgets/tabBar.dart';

import 'package:flutter_ui_demo/Project_learnigs_testing/QuickLinksPages.dart';

import 'IndividualWidgets/dropDown.dart';
import 'IndividualWidgets/geolocator.dart';

class MyMain extends StatelessWidget {
  //child of stl widget
  const MyMain({super.key});
  //super.key is calling syntax for parent class(Stl) constructor{which expect optional key parameter} for providing the reference of Mywidget1 to the stl, so that during updates the network of widgets get updated which will come later
  //stateless widget can be instantitated at compile time only so we use const keyword with constructor of class,

  //static const is required key word for constant values that are fields of class not the constructor
  static const mssg = "Hello mssg"; //every object of it  can use it

  @override //overriding the func in stl to use it herre, return type is widget
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false, //remove debug banner
        theme: ThemeData(
          brightness: Brightness.light,
          primaryColor: Colors.deepPurple,
          appBarTheme: AppBarTheme(
            //if we don't define appbaar theme then it will become transparent
            backgroundColor:
                Colors.deepPurple, // Explicitly set the AppBar color
          ),
        ),
        home: Clone2());
  }
}

void main() {
  //ListView'S LIST
  // Stateobj.buildlist();
  //see log messages in debug console, it is a simple log which prints string-note we can filter them in debug console search bar
  // log(Stateobj.cards.toString());
  runApp(
      MyMain()); //new keyword is not required because in newer dart versions and directly an object can be created
}
