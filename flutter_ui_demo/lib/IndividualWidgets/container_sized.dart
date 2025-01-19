import 'package:flutter/material.dart';

//Container and sized box are like placed holders to hold something
//differences in sized box are that it is cheaper operation but less renderable than a container
//that is it has less cutomizations

//typical screen size is 640*340...we are not focussing on responsive view now, so providing fix values of h and w

class MyBox1 extends StatelessWidget {
  //defining const constructor-longer syntax
  //Key is a class key1 is input named parameter
  //nullable because if we not want to pass any key
  const MyBox1({Key? key1})
      : super(key: key1); //passing named parameter key in parent constructor

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //roof
      appBar: AppBar(
        title: Text("Container and Sized box"),
        // backgroundColor: Colors.deepPurple,              can change explicitly
      ) //Appbar widget
      ,
      //body is remaining space inside the scaffold widget
      body: Center(
        //for centering the child
        child: Container(
          padding: EdgeInsets.all(5),
          // color: Colors.blueGrey, //color of container
          height:
              150, //units are dp        //if we not provide h and w it is wrap content
          width:
              150, //h&w not provided:if we not use center h and w will be wrap content, if we use it then it will be match parent
          decoration: BoxDecoration(
              color: Colors.blue,
              // shape: BoxShape.circle,
              borderRadius: BorderRadius.only(
                  bottomRight: Radius.circular(25),
                  topLeft: Radius.circular(25)),
              boxShadow: [
                BoxShadow(
                    blurRadius:
                        20, //radius of circle which defined blurred area behind sized box
                    spreadRadius: 5, //spreadradiii
                    color: Colors.white)
              ]),

          // child: Center(
          //     child: Text(
          //   "This is a sized box",
          //   style: TextStyle(fontSize: 24), //sp
          // )),
          child: Center(
            child: Container(
              margin: EdgeInsets.all(10),
              color: Colors.red,
              child: Center(
                child: Text(
                  "Frame",
                  style: TextStyle(fontSize: 20),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
