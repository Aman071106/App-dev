import 'package:flutter/material.dart';

//utilities

class Appcolor {
  static Color bgcolor = Colors.lightBlueAccent.shade400.withValues(alpha: 0.5);

  static List<BoxShadow> shadow = [
    BoxShadow(
        color: Colors.deepOrange.shade600.withValues(alpha: 0.4),
        blurRadius: 25,
        spreadRadius: 2,
        offset: Offset(-5, -30)),
    BoxShadow(color: Colors.green.shade600.withValues(alpha: 0.4))
  ];
}
