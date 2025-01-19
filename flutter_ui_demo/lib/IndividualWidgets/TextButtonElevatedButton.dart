import 'package:flutter/material.dart';

class Buttons extends StatelessWidget {
  const Buttons({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Buttons'),
        ),
        body: Container(
            height: 700,
            width: 400,
            color: Colors.grey,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextButton(
                    onPressed: () {},
                    style: ButtonStyle(
                        elevation: WidgetStateProperty.all(
                            5), //elevation is genrally given 10 or 5
                        overlayColor: WidgetStateProperty.all(Colors.red),
                        padding: WidgetStatePropertyAll(EdgeInsets.all(
                            20)), //padding creates space inside it
                        shadowColor: WidgetStatePropertyAll(Colors.blue),
                        backgroundColor:
                            // MaterialStateProperty.all(Colors.amber)),    //for older versions but still works
                            WidgetStateProperty.all(Colors.yellow)),
                    child: Text('Press!',
                        style: TextStyle(
                            fontSize: 20,
                            color: Colors
                                .black))) //increase ont size to increase button size
                ,
                SizedBox(
                  height: 20,
                  width: 20,
                ),
                Container(
                  height: 70,
                  width: 250,
                  child: ElevatedButton(
                      //style is same
                      style: ButtonStyle(
                          backgroundColor: WidgetStatePropertyAll(Colors.red),
                          shape: WidgetStateProperty.all(RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(40)))),
                      onPressed: () {},
                      //how to get theme colors
                      child: Text(
                        'El Button',
                        style: TextStyle(color: Theme.of(context).primaryColor),
                      )),
                )
              ],
            ) //compulsory child,pressed=(){} meansn lambda fn
            ));
  }
}


//buttons dont have height and width we can wrap them in container, and use paddings