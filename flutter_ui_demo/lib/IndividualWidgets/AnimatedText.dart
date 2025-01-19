import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:animated_text_kit/animated_text_kit.dart';

class Animatedtext extends StatelessWidget {
  const Animatedtext({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Animation stuff #1'),
      ),
      body: Center(
        child: AnimatedTextKit(
          animatedTexts: [
            RotateAnimatedText("Aman Gupta",
                textStyle: TextStyle(fontSize: 30),
                duration: Duration(milliseconds: 100),
                rotateOut: true),
            TypewriterAnimatedText("typewriter")
          ],
          onTap: () => log("tapped"),
          stopPauseOnTap: true,
          totalRepeatCount: 20,
          pause: Duration(milliseconds: 500),
        ),
      ),
    );
  }
}
