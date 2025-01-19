//imports
import 'package:flutter/material.dart';

class RowsColsWrap extends StatelessWidget {
  const RowsColsWrap({super.key});

  @override
  Widget build(BuildContext context) {
    //for getting h and w of phone screen so that we can use a container that is taking size of the screen, it makes it more responsive than providing hardcore values
    //we are using a container as the main box in body

    var w = MediaQuery.of(context).size.width;
    var h = MediaQuery.of(context).size.height;

    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Rows and Coloumns")),
      ),
      body: Container(
        height:
            h, //by defualt the rows inside container is left aligned and centered vertically,wraps are aligned topleft by default
        width:
            w, //decrease it such that row moves out-we will get a error in screen of phone
        decoration: BoxDecoration(
            color: Colors
                .grey //tip: for debugging purposes- we will see yellow color behind the app bar also if we comment(remove) the appbar-this signifyies the body area completely
            ),
        child: Wrap(
          //used in place of rows and coloumns as even if we decrease the dimensions such that children doesn't fit inside then it wraps them and doesn't give error
          direction: Axis
              .vertical, //by default it has vertical, no main and cross axis in wrap
          alignment: WrapAlignment
              .center, //etc with respect to parent  along direction axis
          children: [
            //children
            Container(
              height: 40,
              width: 40,
              color: Colors.red,
            ),
            Container(height: 40, width: 40, color: Colors.blue),
            Container(height: 40, width: 40, color: Colors.green),
            Container(
              height: 40,
              width: 40,
              color: Colors.pink,
            ),
            Container(height: 40, width: 40, color: Colors.amber),
            Container(height: 40, width: 40, color: Colors.blueGrey)
          ],
        ),

        // child: Row(
        //   mainAxisAlignment:
        //       // MainAxisAlignment.center, //main aaxis is its horizontal axis
        //       MainAxisAlignment
        //           .spaceEvenly, //some parameters: spaceevenly,spacearound,between-Each item gets an equal amount of space on both sides, but the spaces between items are larger than the spaces at the edges. etc...ctrl+space and use them
        //   // crossAxisAlignment:
        //   // CrossAxisAlignment.stretch, //see it is its vertical axis
        //   // spacing: 100, //horizontal spacing
        //   children: [
        //     //children
        //     Container(
        //       height: 60,
        //       width: 60,
        //       color: Colors.red,
        //     ),
        //     Container(height: 40, width: 40, color: Colors.red),
        //     Container(height: 20, width: 20, color: Colors.red),
        //     Container(
        //       height: 20,
        //       width: 20,
        //       color: Colors.red,
        //     ),
        //     Container(height: 40, width: 40, color: Colors.red),
        //     Container(height: 60, width: 60, color: Colors.red)
        //   ],
        // ),
      ),
      // body: ,
    );
  }
}
