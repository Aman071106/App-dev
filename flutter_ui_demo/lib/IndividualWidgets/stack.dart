import 'package:flutter/material.dart';

//import the class which has utilities
import 'package:flutter_ui_demo/utils/colors.dart';

class StackWidget extends StatelessWidget {
  const StackWidget({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Visa Ui"),
      ),
      body: Container(
        decoration: BoxDecoration(color: Colors.lightBlueAccent),
        height: MediaQuery.of(context).size.height,
        width: MediaQuery.of(context).size.width,
        child: Stack(
          children: [
            Center(
              child: Card(
                color: Colors.transparent,
                elevation: 40,
                shadowColor: Colors.lightBlueAccent,
                child: Container(
                  height: 200,
                  width: 320,
                  decoration: BoxDecoration(
                      boxShadow: Appcolor.shadow,
                      image: DecorationImage(
                          fit: BoxFit.cover,
                          opacity: 0.4,
                          image: AssetImage("assets/visa_bg.png")),
                      color: Colors.transparent,
                      shape: BoxShape.rectangle,
                      borderRadius: BorderRadius.all(Radius.circular(10))),
                ),
              ),
            ),
            Center(
              child: Container(
                height: 200,
                width: 320,
                child: Stack(children: [
                  Positioned(
                      top: 14,
                      left: 5,
                      child: Container(
                        height: 27,
                        width: 70,
                        decoration: BoxDecoration(
                            // color: Colors.amber,
                            image: DecorationImage(
                                colorFilter: ColorFilter.mode(
                                  const Color.fromARGB(255, 0, 140, 255)
                                      .withValues(alpha: 1), // Color to apply
                                  BlendMode.modulate, // Blend mode
                                ),
                                fit: BoxFit.fill,
                                image: AssetImage("assets/visa_logo_2.png"))),
                      )),
                  Positioned(
                      top: 45,
                      left: 14,
                      child: Text(
                        "It's where you want to be",
                        style: TextStyle(
                            color: const Color.fromRGBO(0, 0, 0, 0.5),
                            fontWeight: FontWeight.w400,
                            fontSize: 12,
                            fontStyle: FontStyle.italic),
                      )),
                  Positioned(
                      bottom: 10,
                      left: 15,
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            "5687  7899   3787   XXXX",
                            textAlign: TextAlign.start,
                            style: TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w700,
                                fontSize: 18),
                          ),
                          Text(
                            "AMAN GUPTA",
                            textAlign: TextAlign.start,
                            style: TextStyle(
                                color: Colors.black,
                                fontWeight: FontWeight.w300),
                          )
                        ],
                      )),
                  Positioned(
                      top: 15,
                      right: 15,
                      child: Container(
                        width: 50,
                        height: 30,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.all(Radius.circular(12)),
                          image: DecorationImage(
                              image: AssetImage("assets/visa_logo.jpg")),
                        ),
                      ))
                ]),
              ),
            )
          ],
        ),
      ),
    );
  }
}
